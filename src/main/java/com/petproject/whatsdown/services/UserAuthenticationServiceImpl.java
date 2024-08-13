package com.petproject.whatsdown.services;

import com.petproject.whatsdown.models.User;
import com.petproject.whatsdown.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAuthenticationServiceImpl implements UserAuthenticationService {

    @Autowired private UserRepository userRepository;

    @Override
    public User loadUserByUsername(String userName) {
        var user = userRepository.findByUsername(userName);
        if (user != null)
            return user;
        throw new UsernameNotFoundException("Username " + userName + " not found.");
    }

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }
}
