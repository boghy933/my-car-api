package com.tracker.mycartracker.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.sql.Timestamp;
import java.util.UUID;

public class Car {
    private final UUID id;
    private final Timestamp timestamp;
    private final Location location;
    private final UUID userId;

    public Car(@JsonSetter("id") UUID id, Location location, UUID userId) {
        this.id = id;
        this.location = location;
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.userId = userId;
    }

    @JsonGetter("timestamp")
    public Timestamp getTimestamp() {
        return timestamp;
    }

    @JsonGetter
    public Location getLocation() {
        return location;
    }

    @JsonGetter("id")
    public UUID getId() {
        return id;
    }

    @JsonGetter("userId")
    public UUID getUserId() {
        return userId;
    }

}
