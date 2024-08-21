package com.petproject.whatsdown.service;

import com.petproject.whatsdown.model.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

// восстановление паролей
// смена паролей

public interface UserAuthenticationService extends UserDetailsService {

    UserEntity loadUserByUsername(String userName);

    UserEntity registerUser(String username, String password);
}
