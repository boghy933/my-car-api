package com.tracker.mycartracker.controller;

import com.tracker.mycartracker.model.Car;
import com.tracker.mycartracker.service.CarService;
import com.tracker.mycartracker.model.Location;
import com.tracker.mycartracker.model.User;

import com.tracker.mycartracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/car")
@RestController
public class CarController {
    private final CarService carService;
    private final UserService userService;

    @Autowired
    public CarController(CarService carService, UserService userService) {
        this.carService = carService;
        this.userService = userService;
    }

    @PostMapping("add")
    public Car insertStatistics(@RequestBody Location location, Authentication auth) {
        User user = (User) auth.getPrincipal();
        return carService.insertStatistics(location, user);
    }

    @GetMapping
    public List<Car> getAllStatistics(Authentication auth) {
        User user = (User) auth.getPrincipal();
        return carService.getAllStatistics(user);
    }
}
