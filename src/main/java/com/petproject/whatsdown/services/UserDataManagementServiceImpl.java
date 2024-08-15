package com.petproject.whatsdown.services;

import com.petproject.whatsdown.models.User;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserDataManagementServiceImpl implements UserDataManagementService {

    @Override
    public Object getCurrentUserPrincipal() throws AuthenticationException {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!authentication.isAuthenticated()) {
            throw new AuthenticationException("No authorized user found");
        };
        return authentication.getPrincipal();
    }
}
