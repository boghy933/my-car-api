package com.tracker.mycartracker.service;

import com.tracker.mycartracker.dao.TelemetryDao;
import com.tracker.mycartracker.model.Telemetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelemetryService {
    private final TelemetryDao telemetryDao;

    @Autowired
    public TelemetryService(@Qualifier("telemetryDB") TelemetryDao telemetryDao) {
        this.telemetryDao = telemetryDao;
    }

    public Telemetry insertTelemetry(Telemetry telemetry) {
        return telemetryDao.insertTelemetry(telemetry);
    }

    public List<Telemetry> getAllTelemetries() {
        return telemetryDao.getAllTelemetries();
    }
}
