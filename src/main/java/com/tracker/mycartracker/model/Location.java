package com.tracker.mycartracker.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {
    private final float latitude;
    private final float longitude;

    public Location(@JsonProperty("latitude") float latitude, @JsonProperty("longitude") float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @JsonGetter("latitude")
    public float getLatitude() {
        return latitude;
    }

    @JsonGetter("longitude")
    public float getLongitude() {
        return longitude;
    }
}
