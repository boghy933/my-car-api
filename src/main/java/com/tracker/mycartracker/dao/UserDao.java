package com.tracker.mycartracker.dao;

import com.tracker.mycartracker.model.User;

import java.util.List;
import java.util.UUID;

public interface UserDao {
    User getUserByToken(String token);
    User getUserById(UUID id);
    User insertUser(String username);
    List<User> getAllUsers();
}
