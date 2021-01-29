package com.tracker.mycartracker.service;

import com.tracker.mycartracker.dao.UserDao;
import com.tracker.mycartracker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(@Qualifier("userDB")UserDao userDao) {
        this.userDao = userDao;
    }

    public User insertUser(String username, String password, String email, String phone) {
        return userDao.insertUser(username, password, email, phone);
    }

    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    public User getUserByToken(String token) {
        return userDao.getUserByToken(token);
    }
    public User getUserById(UUID id) {
        return userDao.getUserById(id);
    }
}
