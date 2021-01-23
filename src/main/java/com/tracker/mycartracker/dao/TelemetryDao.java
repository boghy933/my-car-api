package com.tracker.mycartracker.dao;

import com.tracker.mycartracker.model.Car;
import com.tracker.mycartracker.model.Telemetry;
import com.tracker.mycartracker.model.User;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

public interface TelemetryDao {

    Telemetry insertTelemetry(UUID id, String latitude, String longitude, int batteryLevel, UUID carId);
    default Telemetry insertTelemetry(Telemetry telemetry) {
        return insertTelemetry(UUID.randomUUID(), telemetry.getLatitude(), telemetry.getLongitude(), telemetry.getBatteryLevel(), telemetry.getCarId());
    }

    List<Telemetry> getAllTelemetries();
    List<Telemetry> searchTelemetriesByDate(Date date);
}
