package com.tracker.mycartracker.model;

import java.util.UUID;

public class Authorities {
    private final UUID id;
    private final String username;
    private final String authority;

    public Authorities(UUID id, String username, String authority) {
        this.id = id;
        this.username = username;
        this.authority = authority;
    }
}
