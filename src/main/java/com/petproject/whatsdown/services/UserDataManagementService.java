package com.petproject.whatsdown.services;

import com.petproject.whatsdown.models.User;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.security.core.Authentication;

public interface UserDataManagementService {

    public Object getCurrentUserPrincipal() throws AuthenticationException;
}
