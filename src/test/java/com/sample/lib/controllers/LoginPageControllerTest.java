package com.sample.lib.controllers;

import com.sample.lib.entities.Student;
import com.sample.lib.services.LoginService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginPageControllerTest {

    @Mock
    LoginService loginService;

    @InjectMocks
    LoginPageController controller;

    private static Student student;

    @BeforeClass
    public static void setUp() throws Exception {
        student = new Student();
        student.setUsername("Bindu");
        student.setPassword("bindu");
    }

    @Test
    public void shouldRenderTheLoginPageIfUserIsNotLoggedIn() throws Exception {
        String expected = "login";
        String actual = controller.showLoginPage(new Student());
        assertEquals(actual, expected);
    }

    @Test
    public void shouldGiveTheProfilePageIfStudentIsLoggedIn() throws Exception {
        String expected = "main";
        HttpServletResponse response = mock(HttpServletResponse.class);
        String username = student.getUsername();
        String password = student.getPassword();
        when(loginService.login(username, password)).thenReturn(true);

        String actual = controller.login(student, response);

        assertEquals(expected, actual);
    }
}