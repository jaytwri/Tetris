package com.example.tetrisgame.app;

public class LoginSession
{
    static LoginSession Instance = new LoginSession();

    int token;
    String username;

    private LoginSession()
    {
        token = -1;
    }

    public static LoginSession getInstance()
    {
        if (Instance == null) Instance = new LoginSession();
        return Instance;
    }

    public int getToken()
    {
        return Instance.token;
    }

    public void setToken(int token)
    {
        Instance.token = token;
    }

    public void setUsername(String name){ Instance.username = name;}

    public String getUsername(){
        return Instance.username;
    }

}