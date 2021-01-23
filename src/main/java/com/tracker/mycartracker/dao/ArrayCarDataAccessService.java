package com.tracker.mycartracker.dao;

import com.tracker.mycartracker.model.Car;
import com.tracker.mycartracker.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("arrayCarDao")
public class ArrayCarDataAccessService implements CarDao {
    private static List<Car> DB = new ArrayList<>();

    @Override
    public Car insertCar(UUID id, UUID userId, String plate) {
        Car car = new Car(id, userId, plate);
        DB.add(car);
        return car;
    }

    @Override
    public List<Car> getAllCars(User user) {
        List<Car> userDB = new ArrayList<>();
        for (Car car: DB) {
            if(car.getUserId() == user.getId()) {
                userDB.add(car);
            }
        }
        return userDB;
    }
}
