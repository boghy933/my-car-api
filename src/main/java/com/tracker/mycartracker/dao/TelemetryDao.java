package com.tracker.mycartracker.dao;

import com.tracker.mycartracker.model.Telemetry;

import java.sql.Date;
import java.util.List;

public interface TelemetryDao {
    Telemetry insertTelemetry(Telemetry telemetry);

    default Telemetry insertTelemetry(String latitude, String longitude, int batteryLevel) {
        Telemetry telemetry = new Telemetry(latitude, longitude, batteryLevel);
        return insertTelemetry(telemetry);
    }

    List<Telemetry> getAllTelemetries();
    List<Telemetry> searchTelemetriesByDate(Date date);
}
