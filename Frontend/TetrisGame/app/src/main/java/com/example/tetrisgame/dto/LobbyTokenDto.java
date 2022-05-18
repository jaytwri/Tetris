package com.example.tetrisgame.dto;

public class LobbyTokenDto {
    int lobbyToken;

    public LobbyTokenDto(int lobbyToken) {
        this.lobbyToken = lobbyToken;
    }

    public LobbyTokenDto() {

    }

    public int getLobbyToken() {
        return lobbyToken;
    }

    public void setLobbyToken(int lobbyToken) {
        this.lobbyToken = lobbyToken;
    }
}
