package com.tracker.mycartracker.service;

import com.tracker.mycartracker.dao.CarDao;
import com.tracker.mycartracker.model.Car;
import com.tracker.mycartracker.model.Location;
import com.tracker.mycartracker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarDao carDao;

    @Autowired
    public CarService(@Qualifier("arrayCarDao") CarDao carDao) {
        this.carDao = carDao;
    }

    public Car insertStatistics(Location location, User user) {
        return carDao.insertStatistics(location, user);
    }

    public List<Car> getAllStatistics(User user) {
        return carDao.getAllStatistics(user);
    }
}
