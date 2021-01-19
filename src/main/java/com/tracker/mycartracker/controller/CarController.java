package com.tracker.mycartracker.controller;

import com.tracker.mycartracker.model.Car;
import com.tracker.mycartracker.service.CarService;
import com.tracker.mycartracker.model.Location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/car")
@RestController
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public int insertStatistics(@RequestBody Location location) {
        return carService.insertStatistics(location);
    }

    @GetMapping
    public List<Car> getAllStatistics() {
        return carService.getAllStatistics();
    }
}
