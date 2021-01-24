package com.tracker.mycartracker.service;

import com.tracker.mycartracker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {

    @Autowired
    protected UserService userService;

    public User authenticateByToken(String token) {
        System.out.println("ciao");
        System.out.println(userService);
        User user = userService.getUserByToken(token);
        System.out.println(user);
        return user;
    }
}
