package com.tracker.mycartracker.dao;

import com.tracker.mycartracker.model.User;
import org.springframework.context.annotation.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface UserDao {
    User getUserByToken(String token);
    User getUserById(UUID id);
    User insertUser(String username, String password, String email, String phone);
    List<User> getAllUsers();
}
