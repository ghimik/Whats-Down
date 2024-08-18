package com.petproject.whatsdown.services;

import com.petproject.whatsdown.models.User;
import org.apache.tomcat.websocket.AuthenticationException;

public interface UserDataManagementService {

    public User getCurrentUser() throws AuthenticationException;
}
