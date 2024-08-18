package com.petproject.whatsdown.service;

import com.petproject.whatsdown.model.User;
import org.apache.tomcat.websocket.AuthenticationException;

public interface UserDataManagementService {

    public User getCurrentUser() throws AuthenticationException;
}
