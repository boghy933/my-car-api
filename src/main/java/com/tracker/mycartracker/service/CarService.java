package com.tracker.mycartracker.service;

import com.tracker.mycartracker.dao.CarDao;
import com.tracker.mycartracker.model.Car;
import com.tracker.mycartracker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarDao carDao;

    @Autowired
    public CarService(@Qualifier("carDB") CarDao carDao) {
        this.carDao = carDao;
    }

    public Car insertCar(User user, String plate) {
        return carDao.insertCar(user, plate);
    }

    public List<Car> getAllCars(User user) {
        return carDao.getAllCars(user);
    }
}
