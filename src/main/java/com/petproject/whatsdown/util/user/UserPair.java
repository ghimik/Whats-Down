package com.petproject.whatsdown.util.user;

import com.petproject.whatsdown.model.User;

public class UserPair {

    private User first;

    private User second;

    public User getFirst() {
        return first;
    }

    public void setFirst(User first) {
        this.first = first;
    }

    public User getSecond() {
        return second;
    }

    public void setSecond(User second) {
        this.second = second;
    }

    public static UserPairBuilder builder() {
        return new UserPairBuilder();
    }
}
