package com.petproject.whatsdown.service;

import com.petproject.whatsdown.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

// восстановление паролей
// смена паролей

public interface UserAuthenticationService extends UserDetailsService {

    User loadUserByUsername(String userName);

    User registerUser(String username, String password);
}
