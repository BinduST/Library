package com.sample.lib.controllers;

import com.sample.lib.entities.Student;
import com.sample.lib.services.LoginService;
import com.sample.lib.services.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.UnknownHostException;

@Controller
public class LoginPageController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String redirectToLoginPage() {
        return "redirect:login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage(Student student) {
        return "login";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String showSignUpPage(Student student) {
        return "signUp";
    }

    @RequestMapping(value = "/signUp.html", method = RequestMethod.GET)
    public String redirectToSignUpPage(Student student) {
        return "redirect:signUp";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@Valid Student student, HttpServletResponse response) throws UnknownHostException {
        String username = student.getUsername();
        String password = student.getPassword();
        if (loginService.login(username, password)) {
            response.addCookie(new Cookie("username", username));
            response.addCookie(new Cookie("password", password));
            return "main";
        } else {
            System.out.println("Incorrect username or password");
            return "login";
        }
    }
}