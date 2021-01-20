package com.tracker.mycartracker.controller;

import com.tracker.mycartracker.model.Car;
import com.tracker.mycartracker.service.CarService;
import com.tracker.mycartracker.model.Location;
import com.tracker.mycartracker.model.User;

import com.tracker.mycartracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Car insertStatistics(@RequestBody Location location) {
        User user = userService.getUserByToken("demo-token");
        return carService.insertStatistics(location, user);
    }

    @GetMapping
    public List<Car> getAllStatistics() {
        return carService.getAllStatistics();
    }
}
