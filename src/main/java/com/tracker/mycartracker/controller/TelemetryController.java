package com.tracker.mycartracker.controller;

import com.sun.istack.NotNull;
import com.tracker.mycartracker.model.Telemetry;
import com.tracker.mycartracker.service.TelemetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/telemetry")
@RestController
public class TelemetryController {
    private final TelemetryService telemetryService;

    @Autowired
    public TelemetryController(TelemetryService telemetryService) {
        this.telemetryService = telemetryService;
    }

    @PostMapping
    public Telemetry insertTelemetry(@NotNull @RequestBody Telemetry telemetry, Authentication auth) {
        return telemetryService.insertTelemetry(telemetry);
    }

    @GetMapping
    public List<Telemetry> getAllTelemetries() {
        return telemetryService.getAllTelemetries();
    }
}
