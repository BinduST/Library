package com.sample.lib.controllers;

import com.sample.lib.dao.BaseDao;
import com.sample.lib.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.UnknownHostException;


@Controller
public class IndexPageController extends WebMvcConfigurerAdapter {

    @Autowired
    BaseDao baseDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showForm(Student student) {
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, params = {"signup"})
    public String signUp(@Valid Student student, BindingResult bindingResult, HttpServletResponse response) throws UnknownHostException {
        if (bindingResult.hasErrors())
            return "index";
        else {
            if (baseDao.insert(student)) {
                response.addCookie(new Cookie("username", student.getUsername()));
                response.addCookie(new Cookie("password", student.getPassword()));
                return "main";
            } else {
                System.out.println("Username already exists !!!");
                return "index";
            }
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, params = {"login"})
    public String login(@Valid Student student, HttpServletResponse response) throws UnknownHostException {
        String username = student.getUsername();
        String password = student.getPassword();
        if (baseDao.findBy(username, password)) {
            response.addCookie(new Cookie("username", username));
            response.addCookie(new Cookie("password", password));
            System.out.println(showAll());
            return "main";
        } else {
            System.out.println("Incorrect username or password");
            return "index";
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, params = {"take"})
    public String showAll() throws UnknownHostException {
        System.out.println("In take....");
        System.out.println(baseDao.showAll() + "  == baseDao.showAll()");
        return "main";
    }
}