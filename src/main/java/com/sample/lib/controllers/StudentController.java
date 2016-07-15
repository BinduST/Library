package com.sample.lib.controllers;

import com.sample.lib.entities.Book;
import com.sample.lib.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.UnknownHostException;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/take", method = RequestMethod.GET)
    public Book borrow(String bookName) throws UnknownHostException {
        return studentService.borrow(bookName);
    }
}