package com.tracker.mycartracker.dao;

import com.tracker.mycartracker.model.Car;
import com.tracker.mycartracker.model.Telemetry;
import com.tracker.mycartracker.model.User;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public interface TelemetryDao {

    Telemetry insertTelemetry(UUID id, float latitude, float longitude, int batteryLevel, UUID carId, Timestamp timestamp);
    default Telemetry insertTelemetry(Telemetry telemetry) {
        return insertTelemetry(UUID.randomUUID(), telemetry.getLatitude(), telemetry.getLongitude(), telemetry.getBatteryLevel(), telemetry.getCarId(), telemetry.getTimestamp());
    }

    List<Telemetry> getAllTelemetries();
    List<Telemetry> searchTelemetriesByDate(Date date);
}
