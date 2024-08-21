package com.petproject.whatsdown.dto;

import com.petproject.whatsdown.model.UserEntity;

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

    public static UserDataDto from(UserEntity userEntity) {
        return new UserDataDto(userEntity.getUsername());
    }
}
