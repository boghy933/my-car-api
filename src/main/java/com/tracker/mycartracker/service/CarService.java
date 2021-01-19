package com.tracker.mycartracker.service;

import com.tracker.mycartracker.dao.CarDao;
import com.tracker.mycartracker.model.Car;
import com.tracker.mycartracker.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarDao carDao;

    @Autowired
    public CarService(@Qualifier("arrayDao") CarDao carDao) {
        this.carDao = carDao;
    }

    public int insertStatistics(Location location) {
        return carDao.insertStatistics(location);
    }

    public List<Car> getAllStatistics() {
        return carDao.getAllStatistics();
    }
}
