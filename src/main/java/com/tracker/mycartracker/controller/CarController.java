package com.tracker.mycartracker.controller;

import com.tracker.mycartracker.model.Car;
import com.tracker.mycartracker.service.CarService;
import com.tracker.mycartracker.model.User;

import com.tracker.mycartracker.service.UserService;
import org.apache.camel.util.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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

    @PostMapping
    public User insertCar(@RequestBody JsonObject carJson, Authentication auth) {
        return (User) auth.getPrincipal();
        //User user = (User) auth.getPrincipal();
        //return carService.insertCar(user, carJson.get("plate").toString());
    }

    @GetMapping
    public List<Car> getAllStatistics(Authentication auth) {
        User user = (User) auth.getPrincipal();
        return carService.getAllCars(user);
    }
}
