package com.petproject.whatsdown.services;

import com.petproject.whatsdown.models.User;

public interface UserAuthenticationService {

    User loadUserByUsername(String userName);

    User registerUser(User user);
}
