package com.tracker.mycartracker.model;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.UUID;

public class User {
    private final UUID id;
    private final String token;
    private final String username;

    public User(UUID id, @JsonSetter("token") String token, @JsonSetter("username") String username) {
        this.id = id;
        this.token = token;
        this.username = username;
    }

    @JsonGetter("id")
    public UUID getId() {
        return id;
    }

    @JsonGetter("token")
    public String getToken() {
        return token;
    }

    @JsonGetter("username")
    public String getUsername() {
        return username;
    }
}
