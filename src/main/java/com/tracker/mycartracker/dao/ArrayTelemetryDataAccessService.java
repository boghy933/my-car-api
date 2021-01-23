package com.tracker.mycartracker.dao;

import com.tracker.mycartracker.model.Telemetry;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("arrayTelemetryDao")
public class ArrayTelemetryDataAccessService implements TelemetryDao {
    private static List<Telemetry> DB = new ArrayList<>();

    @Override
    public Telemetry insertTelemetry(UUID id, String latitude, String longitude, int batteryLevel, UUID carId) {
        Telemetry telemetry = new Telemetry(id, latitude, longitude, batteryLevel, carId);
        DB.add(telemetry);
        return telemetry;
    }

    @Override
    public List<Telemetry> getAllTelemetries() {
        return DB;
    }

    @Override
    public List<Telemetry> searchTelemetriesByDate(Date date) {
        // TODO
        return DB;
    }
}
