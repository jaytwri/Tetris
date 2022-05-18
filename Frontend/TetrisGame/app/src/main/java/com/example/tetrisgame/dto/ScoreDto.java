package com.example.tetrisgame.dto;

public class ScoreDto {
    int score;
    UserDto user;

    public ScoreDto(int score, UserDto user) {
        this.score = score;
        this.user = user;
    }

    public ScoreDto() {
    }



    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}
