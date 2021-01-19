package com.tracker.mycartracker.dao;

import com.tracker.mycartracker.model.Car;
import com.tracker.mycartracker.model.Location;

import java.util.List;
import java.util.UUID;

public interface CarDao {
    int insertStatistics(UUID id, Location location);

    default int insertStatistics(Location location) {
        UUID id =  UUID.randomUUID();
        return insertStatistics(id, location);
    }

    List<Car> getAllStatistics();
}
