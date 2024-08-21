package com.petproject.whatsdown.service;

import com.petproject.whatsdown.model.UserEntity;
import org.apache.tomcat.websocket.AuthenticationException;

public interface UserDataManagementService {

    public UserEntity getCurrentUser() throws AuthenticationException;
}
