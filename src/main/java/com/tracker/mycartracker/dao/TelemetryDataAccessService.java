package com.tracker.mycartracker.dao;

import com.tracker.mycartracker.model.Car;
import com.tracker.mycartracker.model.Telemetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Repository("telemetryDB")
public class TelemetryDataAccessService implements TelemetryDao {

    final private JdbcTemplate jdbcTemplate;

    @Autowired
    public TelemetryDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Telemetry insertTelemetry(UUID id, float latitude, float longitude, int batteryLevel, UUID carId, Timestamp timestamp) {

        if (timestamp == null) {
            timestamp = new Timestamp(System.currentTimeMillis());
        }

        jdbcTemplate.update("INSERT INTO telemetries (id, carId, timestamp, batteryLevel, latitude, longitude) VALUES (?,?,?,?,?,?)", id, carId, timestamp, batteryLevel, latitude, longitude);

        List<Telemetry> telemetries = jdbcTemplate.query("SELECT * FROM telemetries WHERE id = ? LIMIT 1", ((resultSet, i) -> {
            return new Telemetry(
                    UUID.fromString(resultSet.getString("id")),
                    resultSet.getFloat("latitude"),
                    resultSet.getFloat("longitude"),
                    resultSet.getInt("batteryLevel"),
                    UUID.fromString(resultSet.getString("carId")),
                    resultSet.getTimestamp("timestamp")
            );
        }), id);

        return telemetries.get(0);
    }

    @Override
    public List<Telemetry> getAllTelemetries() {
        List<Telemetry> telemetries = jdbcTemplate.query("SELECT * FROM telemetries", ((resultSet, i) -> {
            return new Telemetry(
                    UUID.fromString(resultSet.getString("id")),
                    resultSet.getFloat("latitude"),
                    resultSet.getFloat("longitude"),
                    resultSet.getInt("batteryLevel"),
                    UUID.fromString(resultSet.getString("carId")),
                    resultSet.getTimestamp("timestamp")
            );
        }));

        return telemetries;
    }

    @Override
    public List<Telemetry> searchTelemetriesByDate(Date date) {
        return null;
    }
}
