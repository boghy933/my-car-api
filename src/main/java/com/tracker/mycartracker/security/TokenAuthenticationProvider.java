package com.tracker.mycartracker.security;

import com.tracker.mycartracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;

@Component
public class TokenAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private UserService userService;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken auth) throws AuthenticationException {
        Object token = auth.getCredentials();
        com.tracker.mycartracker.model.User user = userService.getUserByToken(String.valueOf(token));
        if (user == null) {
            new BadCredentialsException("Invalid authentication token=" + token);
        }
        return User.builder().username(user.getUsername()).password(user.getPassword()).roles("user").build();
    }
}
