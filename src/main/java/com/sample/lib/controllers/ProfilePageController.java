package com.sample.lib.controllers;

import com.mongodb.DBObject;
import com.sample.lib.dao.BooksDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.UnknownHostException;
import java.util.List;

@Controller
public class ProfilePageController {

    @Autowired
    BooksDao booksDao;

    @RequestMapping(value = "/main/getAllBookDetails", method = RequestMethod.GET)
    public List<DBObject> getAllBookDetails() throws UnknownHostException {
        return booksDao.showAll();
    }
}