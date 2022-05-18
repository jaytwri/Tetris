package com.example.tetrisgame.api;

import com.example.tetrisgame.dto.AdminUserDto;
import com.example.tetrisgame.dto.LobbyTokenDto;
import com.example.tetrisgame.dto.Message;
import com.example.tetrisgame.dto.UserDto;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface LobbyApi {
    @GET("/lobby/create/{token}")
    Call<LobbyTokenDto> createLobby(@Path("token") int token);

    @GET("/lobby/join/{lobbyToken}/{token}")
    Call<LobbyTokenDto> joinLobby(@Path("lobbyToken") int lobbyToken, @Path("token") int token);

    @GET("/lobby/{lobbyToken}")
    Call<List<UserDto>> getUsers(@Path("lobbyToken") int lobbyToken);

    @DELETE("/lobby/{lobbyToken}")
    Message deleteLobby(@Path("lobbyToken") int lobbyToken);
}