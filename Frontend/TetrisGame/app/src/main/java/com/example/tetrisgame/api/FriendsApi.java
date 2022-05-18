package com.example.tetrisgame.api;

import com.example.tetrisgame.dto.AdminUserDto;
import com.example.tetrisgame.dto.UserDto;

import java.util.List;
import java.util.Optional;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface FriendsApi {
    @POST("/friends/{token}")
    Call<Void> addFriend(@Path("token") int token, @Body UserDto friend);

    @GET("/friends/{token}")
    Call<List<UserDto>> getFriends(@Path("token") int token);

    @DELETE("/friends/{token}")
    Call<Void> removeFriends(@Path("token") int token, @Body UserDto friend);

    @POST("/admin/{adminPassword}/friend/{username}")
    Call<Void> adminAddFriend(@Path("adminPassword") String adminPassword, @Path("username") String username, @Body UserDto friend);

    @GET("/admin/{adminPassword}/friend/{username}")
    Call<List<AdminUserDto>> adminGetFriends(@Path("adminPassword") String adminPassword, @Path("username") String username);

    @DELETE("/admin/{adminPassword}/friend/{username}")
    Call<Void> adminRemoveFriend(@Path("adminPassword") String adminPassword, @Path("username") String username);
}
