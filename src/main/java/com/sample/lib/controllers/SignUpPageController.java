package com.sample.lib.controllers;

import com.sample.lib.entities.Student;
import com.sample.lib.services.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.net.UnknownHostException;

@Controller
public class SignUpPageController {

    @Autowired
    private SignUpService signUpService;

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String signUp(@Valid Student student, BindingResult bindingResult) throws UnknownHostException {
        if (bindingResult.hasErrors())
            return "signUp";
        else {
            if (signUpService.register(student))
                return "main";
            else {
                System.out.println("Username already exists !!!");
                return "signUp";
            }
        }
    }
}