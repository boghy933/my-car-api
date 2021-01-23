package com.tracker.mycartracker.dao;

import com.tracker.mycartracker.model.Car;
import com.tracker.mycartracker.model.User;

import java.util.List;
import java.util.UUID;

public interface CarDao {
    Car insertCar(UUID id, UUID userId, String plate);

    default Car insertCar(User user, String plate) {
        UUID id =  UUID.randomUUID();
        UUID userId = user.getId();
        return insertCar(id, userId, plate);
    }

    List<Car> getAllCars(User user);
}
