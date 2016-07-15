package com.sample.lib.controllers;

import com.sample.lib.entities.Book;
import com.sample.lib.services.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StudentControllerTest {

    @Mock
    StudentService studentService;

    @InjectMocks
    StudentController studentController;

    @Test
    public void shouldAllowToTakeABook() throws Exception {
        String bookName = "War and peace";
        Book expected = new Book();
        when(studentService.borrow(bookName)).thenReturn(expected);
        Book actual = studentController.borrow(bookName);
        assertEquals(expected, actual);
    }
}