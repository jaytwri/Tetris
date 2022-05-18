package com.example.tetrisgame.api;

import com.example.tetrisgame.dto.AdminUserDto;
import com.example.tetrisgame.dto.ScoreDto;
import com.example.tetrisgame.dto.UserDto;

import java.util.List;
import java.util.Optional;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ScoreApi {
    @GET("/score")
    Call<List<ScoreDto>> getAllScores();

    @POST("/score/{token}")
    Call<Void> postScore(@Path("token") int token, @Body ScoreDto score);

}
