package com.tracker.mycartracker.dao;

import com.tracker.mycartracker.model.Car;
import com.tracker.mycartracker.model.Location;
import com.tracker.mycartracker.model.User;

import java.util.List;
import java.util.UUID;

public interface CarDao {
    Car insertStatistics(UUID id, Location location, UUID userId);

    default Car insertStatistics(Location location, User user) {
        UUID id =  UUID.randomUUID();
        UUID userId = user.getId();
        return insertStatistics(id, location, userId);
    }

    List<Car> getAllStatistics(User user);
}
