package com.sample.lib.controllers;

import com.sample.lib.entities.Student;
import com.sample.lib.dao.BaseDao;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class IndexPageControllerTest {
    @Mock
    BaseDao baseDao;

    @InjectMocks
    IndexPageController controller;

    private static Student student;

    @BeforeClass
    public static void setUp() throws Exception {
        student = new Student();
        student.setUsername("Bindu");
        student.setPassword("bindu");
    }

    @Test
    public void shouldRenderTheLoginPageIfUserIsNotLoggedIn() throws Exception {
        String expected = "index";
        String actual = controller.showForm(new Student());
        assertSame(actual, expected);
    }

    @Test
    public void shouldRenderTheProfilePageIfStudentHasRegistered() throws Exception {
        String expected = "main";
        BindingResult bindingResult = mock(BindingResult.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(baseDao.insert(student)).thenReturn(true);
        String actual = controller.signUp(student, bindingResult, response);

        assertSame(expected, actual);
    }

    @Test
    public void shouldGiveTheProfilePageIfStudentIsLoggedIn() throws Exception {
        String expected = "main";
        HttpServletResponse response = mock(HttpServletResponse.class);
        String username = student.getUsername();
        String password = student.getPassword();
        when(baseDao.findBy(username, password)).thenReturn(true);

        String actual = controller.login(student, response);

        assertSame(expected, actual);
    }

    @Test
    public void shouldNotAllowToRegisterAStudentIfValidationViolates() throws Exception {
        Student student = new Student();
        student.setUsername("b");
        student.setPassword("");

        BindingResult bindingResult = mock(BindingResult.class);
        when(bindingResult.hasErrors()).thenReturn(true);

        HttpServletResponse response = mock(HttpServletResponse.class);
        String actual = controller.signUp(student, bindingResult, response);

        assertEquals("index", actual);
    }
}