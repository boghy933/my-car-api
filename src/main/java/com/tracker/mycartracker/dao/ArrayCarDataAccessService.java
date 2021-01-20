package com.tracker.mycartracker.dao;

import com.tracker.mycartracker.model.Car;
import com.tracker.mycartracker.model.Location;
import com.tracker.mycartracker.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("arrayCarDao")
public class ArrayCarDataAccessService implements CarDao {
    private static List<Car> DB = new ArrayList<>();

    @Override
    public Car insertStatistics(UUID id, Location location, UUID userId) {
        Car car = new Car(id, location, userId);
        DB.add(car);
        return car;
    }

    @Override
    public List<Car> getAllStatistics(User user) {
        List<Car> userDB = new ArrayList<>();
        for (Car car: DB) {
            if(car.getUserId() == user.getId()) {
                userDB.add(car);
            }
        }
        return userDB;
    }
}
