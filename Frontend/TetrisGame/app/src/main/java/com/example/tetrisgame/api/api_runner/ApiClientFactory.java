package com.example.tetrisgame.api.api_runner;

import com.example.tetrisgame.api.FriendsApi;
import com.example.tetrisgame.api.GameApi;
import com.example.tetrisgame.api.LobbyApi;
import com.example.tetrisgame.api.ScoreApi;
import com.example.tetrisgame.api.SessionApi;
import com.example.tetrisgame.api.UserApi;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class ApiClientFactory {

    static Retrofit apiClientSeed = null;

    static Retrofit GetApiClientSeed() {

        if (apiClientSeed == null) {
            apiClientSeed = new Retrofit.Builder()
                    //.baseUrl("http://69a371c2-52b0-4787-aab0-4da90d22db64.mock.pstmn.io")
                    .baseUrl("http://coms-309-037.class.las.iastate.edu:8080")
                    .addConverterFactory(JacksonConverterFactory.create())
                    .build();
        }
        return apiClientSeed;
    }

    public static SessionApi GetSessionApi(){
        return GetApiClientSeed().create(SessionApi.class);
    }

    public static UserApi GetUserApi(){
        return GetApiClientSeed().create(UserApi.class);
    }

    public static FriendsApi GetFriendsApi() {return GetApiClientSeed().create(FriendsApi.class);}

    public static ScoreApi GetScoreApi() {return GetApiClientSeed().create(ScoreApi.class);}

    public static LobbyApi GetLobbyApi() {return GetApiClientSeed().create(LobbyApi.class);}

    public static GameApi GetGameApi() {return GetApiClientSeed().create(GameApi.class);};
}
