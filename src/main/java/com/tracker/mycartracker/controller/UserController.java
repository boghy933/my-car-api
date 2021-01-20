package com.tracker.mycartracker.controller;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.tracker.mycartracker.model.User;
import com.tracker.mycartracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/user")
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("add")
    public User insertUser(@RequestBody User user) {
        return userService.insertUser(user.getUsername());
    }
}
