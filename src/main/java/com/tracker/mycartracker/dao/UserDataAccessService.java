package com.tracker.mycartracker.dao;

import com.tracker.mycartracker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("userDB")
public class UserDataAccessService implements UserDao {

    final private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User getUserByToken(String token) {
        List<User> users = jdbcTemplate.query("SELECT * FROM users WHERE token = ?", ((resultSet, i) -> {
            return new User(
                    UUID.fromString(resultSet.getString("id")),
                    resultSet.getString("token"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("email"),
                    resultSet.getString("phone")
            );
        }), token);
        return users.get(0);
    }

    @Override
    public User getUserById(UUID id) {
        return null;
    }

    @Override
    public User insertUser(String username, String password, String email, String phone) {

        String token = UUID.randomUUID().toString();
        UUID id = UUID.randomUUID();

        jdbcTemplate.update("INSERT INTO users (id, token, username, password, email, phone) VALUES (?,?,?,?,?,?)", id, token, username, password, email, phone);

        List<User> users = jdbcTemplate.query("SELECT * FROM users WHERE id = ?", ((resultSet, i) -> {
            return new User(
                    UUID.fromString(resultSet.getString("id")),
                    resultSet.getString("token"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("email"),
                    resultSet.getString("phone")
            );
        }), id);

        return users.get(0);
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
