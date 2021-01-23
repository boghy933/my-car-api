package com.tracker.mycartracker.dao;

import com.tracker.mycartracker.model.Car;
import com.tracker.mycartracker.model.Telemetry;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

public interface TelemetryDao {
    Telemetry insertTelemetry(Telemetry telemetry);

    default Telemetry insertTelemetry(String latitude, String longitude, int batteryLevel, UUID carId) {
        Telemetry telemetry = new Telemetry(latitude, longitude, batteryLevel, carId);
        return insertTelemetry(telemetry);
    }

    List<Telemetry> getAllTelemetries();
    List<Telemetry> searchTelemetriesByDate(Date date);
}
