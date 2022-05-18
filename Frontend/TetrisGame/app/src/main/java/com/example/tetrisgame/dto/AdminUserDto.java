package com.example.tetrisgame.dto;

import java.util.Date;

public class AdminUserDto {
    private String username;
    private String password;
    private Date accountCreationTime;

    public AdminUserDto(String username, String password, Date accountCreationTime) {
        this.username = username;
        this.password = password;
        this.accountCreationTime = accountCreationTime;
    }

    public AdminUserDto() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Date getAccountCreationTime() {
        return accountCreationTime;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccountCreationTime(Date accountCreationTime) {
        this.accountCreationTime = accountCreationTime;
    }
}