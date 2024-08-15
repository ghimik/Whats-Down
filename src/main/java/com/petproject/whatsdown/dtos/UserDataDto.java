package com.petproject.whatsdown.dtos;

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
}
