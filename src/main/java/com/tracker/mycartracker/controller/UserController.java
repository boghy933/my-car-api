package com.tracker.mycartracker.controller;

import com.tracker.mycartracker.model.User;
import com.tracker.mycartracker.service.UserService;
import org.apache.camel.util.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("api/v1/user")
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("signUp")
    public User insertUser(@RequestBody JsonObject userJson) {
        return userService.insertUser(userJson.get("username").toString(), userJson.get("password").toString(), userJson.get("email").toString(), userJson.get("phone").toString());
    }

    @PostMapping("signIn")
    public void loginUser(@RequestBody JsonObject loginJson) {
        // TODO
    }

    @PostMapping("resetPassword")
    public void resetUserPassword(@RequestBody JsonObject userJson) {
        // TODO
    }

    @GetMapping(path = "{id}")
    public User getUserById(@PathVariable("id") UUID id) {
        // TODO
        return null;
    }
}
