package com.petproject.whatsdown.service;

import com.petproject.whatsdown.model.User;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserDataManagementServiceImpl implements UserDataManagementService {

    @Override
    public User getCurrentUser() throws AuthenticationException {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!authentication.isAuthenticated()) {
            throw new AuthenticationException("No authorized user found");
        };
        return ((User)authentication.getPrincipal());
    }
}