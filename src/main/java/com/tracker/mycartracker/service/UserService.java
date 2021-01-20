package com.tracker.mycartracker.service;

import com.tracker.mycartracker.dao.UserDao;
import com.tracker.mycartracker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(@Qualifier("arrayUserDao")UserDao userDao) {
        this.userDao = userDao;
    }

    public User insertUser(String username) {
        return userDao.insertUser(username);
    }

    public User getUserByToken(String token) {
        return userDao.getUserByToken(token);
    }
}
