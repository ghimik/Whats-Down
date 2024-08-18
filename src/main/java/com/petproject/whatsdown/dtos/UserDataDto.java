package com.petproject.whatsdown.dtos;

import com.petproject.whatsdown.models.User;

public class UserDataDto {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserDataDto(String username) {
        this.username = username;
    }

    public UserDataDto() {

    }

    public static UserDataDto from(User user) {
        return new UserDataDto(user.getUsername());
    }
}
