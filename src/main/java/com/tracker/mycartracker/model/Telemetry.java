package com.tracker.mycartracker.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

public class Telemetry {
    private final String latitude;
    private final String longitude;
    private final int batteryLevel;
    private final Timestamp timestamp;

    public Telemetry(@JsonProperty("latitude") String latitude, @JsonProperty("longitude") String longitude, @JsonProperty("batteryLevel") int batteryLevel) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.batteryLevel = batteryLevel;
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    @JsonGetter("latitude")
    public String getLatitude() {
        return latitude;
    }

    @JsonGetter("longitude")
    public String getLongitude() {
        return longitude;
    }

    @JsonGetter("timestamp")
    public Timestamp getTimestamp() {
        return timestamp;
    }

    @JsonGetter("batteryLevel")
    public int getBatteryLevel() {
        return batteryLevel;
    }
}
