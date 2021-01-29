package com.tracker.mycartracker.dao;

import com.tracker.mycartracker.model.Authorities;

import java.util.UUID;

public interface AuthoritiesDao {
    Authorities insertDefaultAuthorities(String username);
}
