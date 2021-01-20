package com.tracker.mycartracker.model;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class User {
    private final UUID id;
    private final String token;
    private final String username;
    private final String password;

    public User(UUID id, @JsonSetter("token") String token, @JsonSetter("username") String username, String password) {
        this.id = id;
        this.token = token;
        this.username = username;
        this.password = password;
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

    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return authorities;
    }
}
