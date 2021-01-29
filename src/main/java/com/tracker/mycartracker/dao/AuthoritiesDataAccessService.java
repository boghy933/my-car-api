package com.tracker.mycartracker.dao;

import com.tracker.mycartracker.model.Authorities;
import com.tracker.mycartracker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("authoritiesDB")
public class AuthoritiesDataAccessService implements AuthoritiesDao {

    final private JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthoritiesDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Authorities insertDefaultAuthorities(String username) {
        UUID id = UUID.randomUUID();
        jdbcTemplate.update("INSERT INTO authorities (id, username, authority) VALUES (?,?,?)", id, username, "ROLE_USER");

        List<Authorities> authorities = jdbcTemplate.query("SELECT * FROM authorities WHERE id = ?", ((resultSet, i) -> {
            return new Authorities(
                    UUID.fromString(resultSet.getString("id")),
                    resultSet.getString("username"),
                    resultSet.getString("authority")
            );
        }), id);

        return authorities.get(0);
    }
}
