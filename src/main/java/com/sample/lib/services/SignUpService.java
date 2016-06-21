package com.sample.lib.services;

import com.sample.lib.dao.SignUpDao;
import com.sample.lib.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.UnknownHostException;

@Service
public class SignUpService {

    @Autowired
    private SignUpDao signUpDao;

    public boolean register(Student student) throws UnknownHostException {
        return signUpDao.register(student);
    }
}