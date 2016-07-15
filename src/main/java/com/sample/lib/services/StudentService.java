package com.sample.lib.services;

import com.sample.lib.dao.StudentDao;
import com.sample.lib.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.UnknownHostException;

@Service
public class StudentService {
    @Autowired
    StudentDao studentDao;

    public Book borrow(String bookName) throws UnknownHostException {
        return studentDao.get(bookName);
    }
}
