package com.tracker.mycartracker.security;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tracker.mycartracker.dao.ArrayUserDataAccessService;
import com.tracker.mycartracker.dao.UserDao;
import com.tracker.mycartracker.model.User;
import com.tracker.mycartracker.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;


public class TokenAuthorizationFilter extends OncePerRequestFilter {
    private final String HEADER = "Authorization";
    private final String PREFIX = "Bearer ";
    private final String SECRET = "mySecretToken";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        try {
            if (checkToken(request, response)) {
                User user = validateToken(request);
                if (user != null) {
                    setUpSpringAuthentication(user);
                } else {
                    SecurityContextHolder.clearContext();
                }
            }else {
                SecurityContextHolder.clearContext();
            }
            chain.doFilter(request, response);
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
            return;
        }
    }

    private User validateToken(HttpServletRequest request) {
        String token = request.getHeader(HEADER).replace(PREFIX, "");
        UserDao userDao = new ArrayUserDataAccessService();
        return userDao.getUserByToken(token);
    }

    /**
     * Authentication method in Spring flow
     *
     */
    private void setUpSpringAuthentication(User user) {
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        System.out.println(auth.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    private boolean checkToken(HttpServletRequest request, HttpServletResponse res) {
        String authenticationHeader = request.getHeader(HEADER);
        if (authenticationHeader == null || !authenticationHeader.startsWith(PREFIX))
            return false;
        return true;
    }

}
