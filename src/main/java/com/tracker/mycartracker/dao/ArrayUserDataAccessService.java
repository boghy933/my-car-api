package com.tracker.mycartracker.dao;

import com.tracker.mycartracker.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("arrayUserDao")
public class ArrayUserDataAccessService implements UserDao{
    private static List<User> DB = new ArrayList<>();

    @Override
    public User getUserByToken(String token) {
        for(User user : DB) {
            if(user.getToken().equals(token)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUserById(UUID id) {
        for(User user : DB) {
            if(user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User insertUser(String username) {
        String token = UUID.randomUUID().toString();
        token = "demo-token";
        String password = "qwerty";

        UUID id = UUID.randomUUID();
        User user = new User(id, token, username, password);
        DB.add(user);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return DB;
    }
}
