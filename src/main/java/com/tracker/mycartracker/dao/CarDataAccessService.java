package com.tracker.mycartracker.dao;

import com.tracker.mycartracker.model.Car;
import com.tracker.mycartracker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("carDB")
public class CarDataAccessService implements CarDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CarDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Car insertCar(UUID id, UUID userId, String plate) {
        jdbcTemplate.update("INSERT INTO cars (id, userId, plate) VALUES (?,?,?)", id, userId, plate);

        List<Car> cars = jdbcTemplate.query("SELECT * FROM cars WHERE id = ?", ((resultSet, i) -> {
            return new Car(
                    UUID.fromString(resultSet.getString("id")),
                    UUID.fromString(resultSet.getString("userId")),
                    resultSet.getString("plate")
            );
        }), id);
        return new Car(id, userId, plate);
    }

    @Override
    public List<Car> getAllCars(User user) {
        List<Car> cars = jdbcTemplate.query("SELECT id, userId, plate FROM cars", ((resultSet, i) -> {
            return new Car(
                    UUID.fromString(resultSet.getString("id")),
                    UUID.fromString(resultSet.getString("userId")),
                    resultSet.getString("plate")
            );
        }));
        return cars;
    }
}
