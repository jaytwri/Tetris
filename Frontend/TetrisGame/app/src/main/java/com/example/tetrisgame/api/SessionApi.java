package com.example.tetrisgame.api;

import com.example.tetrisgame.dto.LoginDto;
import com.example.tetrisgame.dto.TokenDto;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface SessionApi {
    @POST("/session")
    Call<TokenDto> logIn(@Body LoginDto loginDto);

    @PUT("/session/{token}")
    void logOut(@Path("token") int token);
}
