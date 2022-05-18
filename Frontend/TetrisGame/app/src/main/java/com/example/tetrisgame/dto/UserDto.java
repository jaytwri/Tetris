package com.example.tetrisgame.dto;

public class UserDto {
    String username;

    public UserDto(String username) {
        this.username = username;
    }

    public UserDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
