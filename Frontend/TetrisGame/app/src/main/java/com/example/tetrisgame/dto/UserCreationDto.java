package com.example.tetrisgame.dto;

public class UserCreationDto {
    String username;
    String password;

    public UserCreationDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserCreationDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
