package com.sample.lib.services;

import com.sample.lib.dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.UnknownHostException;

@Service
public class LoginService {

    @Autowired
    private LoginDao loginDao;

    public boolean login(String username, String password) throws UnknownHostException {
        return loginDao.authenticate(username, password);
    }
}
