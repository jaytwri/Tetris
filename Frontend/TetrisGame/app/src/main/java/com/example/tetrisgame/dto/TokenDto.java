package com.example.tetrisgame.dto;

public class TokenDto {
    int Token;

    public TokenDto(int token) {
        Token = token;
    }

    public TokenDto() {
    }

    public int getToken() {
        return Token;
    }

    public void setToken(int token) {
        Token = token;
    }
}
