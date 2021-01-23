package com.tracker.mycartracker.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.sql.Timestamp;
import java.util.UUID;

public class Car {
    private final UUID id;
    private final UUID userId;
    private final String plate;

    public Car(@JsonSetter("id") UUID id, UUID userId, String plate) {
        this.id = id;
        this.userId = userId;
        this.plate = plate;
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
