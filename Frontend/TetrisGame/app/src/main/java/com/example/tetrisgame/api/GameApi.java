package com.example.tetrisgame.api;


import com.example.tetrisgame.dto.BoardStateDto;

import java.util.Optional;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GameApi {
    @GET("/game/{token}")
    Call<BoardStateDto> getLastGameState(@Path("token") int token);

    @POST("/game/{token}")
    Call<Void> postGameState(@Path("token") int token, @Body BoardStateDto boardState);
}
