package com.tracker.mycartracker.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import java.sql.Timestamp;
import java.util.UUID;

public class Telemetry {
    private final UUID id;
    private final String latitude;
    private final String longitude;
    private final int batteryLevel;
    private final Timestamp timestamp;
    @NotNull
    private final UUID carId;

    public Telemetry(UUID id, @JsonProperty("latitude") String latitude, @JsonProperty("longitude") String longitude, @JsonProperty("batteryLevel") int batteryLevel, @JsonProperty("carId") UUID carId) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.batteryLevel = batteryLevel;
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.carId = carId;
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

    @JsonGetter("carId")
    public UUID getCarId() {
        return carId;
    }
}
