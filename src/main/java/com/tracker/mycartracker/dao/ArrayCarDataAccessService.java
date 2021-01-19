package com.tracker.mycartracker.dao;

import com.tracker.mycartracker.model.Car;
import com.tracker.mycartracker.model.Location;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("arrayDao")
public class ArrayCarDataAccessService implements CarDao {
    private static List<Car> DB = new ArrayList<>();

    @Override
    public int insertStatistics(UUID id, Location location) {
        DB.add(new Car(id, location));
        return 1;
    }

    @Override
    public List<Car> getAllStatistics() {
        return DB;
    }
}
