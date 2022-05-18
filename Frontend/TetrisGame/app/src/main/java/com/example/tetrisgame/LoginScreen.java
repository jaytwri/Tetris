package com.example.tetrisgame;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tetrisgame.api.api_runner.ApiClientFactory;
import com.example.tetrisgame.api.api_runner.SlimCallback;
import com.example.tetrisgame.app.LoginSession;
import com.example.tetrisgame.dto.LoginDto;

public class LoginScreen extends AppCompatActivity {
    public LoginSession loginSession;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        String TAG = LoginScreen.class.getSimpleName();
        Button loginButton = findViewById(R.id.Button_Login);
        TextView usernameField = findViewById(R.id.Text_Username);
        TextView passwordField = findViewById(R.id.Text_Password);
        TextView loginResponse = findViewById(R.id.Login_Response);
        Button returnButton = findViewById(R.id.Login_Return);


        loginButton.setOnClickListener(view -> ApiClientFactory.GetSessionApi().logIn(
                new LoginDto(
                        usernameField.getText().toString(),
                        passwordField.getText().toString()
                )
        ).enqueue(
                new SlimCallback<>((tokenDto -> {
                    loginResponse.setText("Logged In!");
                    LoginSession.getInstance()
                            .setToken(tokenDto.getToken());
                    LoginSession.getInstance().setUsername(usernameField.getText().toString());
                }))
        ));
        returnButton.setOnClickListener(view -> startActivity(new Intent(view.getContext(), MainActivity.class)));

    }
}