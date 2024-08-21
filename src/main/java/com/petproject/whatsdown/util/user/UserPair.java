package com.petproject.whatsdown.util.user;

import com.petproject.whatsdown.model.UserEntity;

public class UserPair {

    private UserEntity first;

    private UserEntity second;

    public UserEntity getFirst() {
        return first;
    }

    public void setFirst(UserEntity first) {
        this.first = first;
    }

    public UserEntity getSecond() {
        return second;
    }

    public void setSecond(UserEntity second) {
        this.second = second;
    }

    public static UserPairBuilder builder() {
        return new UserPairBuilder();
    }
}
