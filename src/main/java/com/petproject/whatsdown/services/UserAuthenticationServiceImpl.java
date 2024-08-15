package com.petproject.whatsdown.services;

import com.petproject.whatsdown.models.User;
import com.petproject.whatsdown.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserAuthenticationServiceImpl implements UserAuthenticationService, UserDetailsService {

    @Autowired private UserRepository userRepository;

    @Autowired private PasswordEncoder passwordEncoder;


    @Override
    public User loadUserByUsername(String userName) {
        var user = userRepository.findByUsername(userName);
        if (user != null)
            return user;
        throw new UsernameNotFoundException("Username " + userName + " not found.");
    }

    @Override
    public User registerUser(String username, String password) {
        var user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        return userRepository.save(user);
    }
}
