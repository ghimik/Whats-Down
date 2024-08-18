package com.petproject.whatsdown.services;

import com.petproject.whatsdown.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserAuthenticationService extends UserDetailsService {

    User loadUserByUsername(String userName);

    User registerUser(String username, String password);
}
