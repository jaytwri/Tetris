package com.example.tetrisgame.api;

import com.example.tetrisgame.dto.AdminUserDto;
import com.example.tetrisgame.dto.Message;
import com.example.tetrisgame.dto.UserCreationDto;
import com.example.tetrisgame.dto.UserDto;

import java.util.List;
import java.util.Optional;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserApi {
    @POST("/user")
    Call<Message> createUser(@Body UserCreationDto userCreationDto);

    @GET("/user")
    Call<List<UserDto>> getAllUsers();

    @GET("/user/{username}")
    Call<UserDto> getUserByUsername(@Path("username") String username);

    @DELETE("/user/{token}")
    Call<Void> deleteUser(@Path("token") int token);

    @GET("/admin/{adminPassword}/user")
    Call<List<AdminUserDto>> adminGetAllUsers(@Path("adminPassword") String adminPassword);

    @GET("/admin/{adminPassword}/user/{username}")
    Call<AdminUserDto> adminGetUserByUsername(@Path("adminPassword") String adminPassword, @Path("username") String username);

    @DELETE("/admin/{adminPassword}/user/{username}")
    Call<Void> adminDeleteUser(@Path("adminPassword") String adminPassword, @Path("username") String username);
}
