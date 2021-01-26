package com.tracker.mycartracker.controller;

import com.tracker.mycartracker.model.User;
import com.tracker.mycartracker.service.UserService;
import org.apache.camel.util.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return userService.insertUser(
                userJson.get("username").toString(),
                passwordEncoder.encode(userJson.get("password").toString()),
                userJson.get("email").toString(),
                userJson.get("phone").toString()
        );
    }

    @PostMapping("signIn")
    public String loginUser(@RequestBody JsonObject loginJson) {
        // TODO
        return "TODO";
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
