package com.petproject.whatsdown.util.user;

import com.petproject.whatsdown.model.UserEntity;
import com.petproject.whatsdown.repository.UserRepository;

public class UserPairBuilder {

    private UserEntity first;

    private UserEntity second;

    private UserRepository userRepository;

    public UserPairBuilder fromRepository(UserRepository repository) {
        this.userRepository = repository;
        return this;
    }

    public UserPairBuilder withFirstUsername(String username) {
        first = userRepository.findByUsername(username);
        return this;
    }

    public UserPairBuilder withSecondUsername(String username) {
        second = userRepository.findByUsername(username);
        return this;
    }

    public UserPair build() {
        UserPair userPair = new UserPair();
        userPair.setFirst(first);
        userPair.setSecond(second);
        return userPair;
    }
}
