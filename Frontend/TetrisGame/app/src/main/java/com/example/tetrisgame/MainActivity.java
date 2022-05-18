package com.example.tetrisgame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button login_button = findViewById(R.id.MainScreen_Login_Button);
        Button AccountButton = findViewById(R.id.MainScreen_CreateAccount_Button);
        Button singleGame = findViewById(R.id.MainScreen_SinglePlayer);
        Button HighScores = findViewById(R.id.HighScoreButton);
        Button LobbyB = findViewById(R.id.LobbyButton);
        TextView logo = findViewById(R.id.Logo);
        logo.setText("\uD83D\uDFE7\uD83D\uDFE7\uD83D\uDFE7\n\uD83D\uDFEA\uD83D\uDFEA\uD83D\uDFEA\n\uD83D\uDFE7\uD83D\uDFEA\uD83D\uDFE7");

        singleGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), TetrisSingle.class));
            }
        });

        singleGame.setOnClickListener(view -> startActivity(new Intent(view.getContext(), TetrisSingle.class)));

        login_button.setOnClickListener(view -> startActivity(new Intent(view.getContext(), LoginScreen.class)));


        AccountButton.setOnClickListener(view -> startActivity(new Intent(view.getContext(), AccountCreation.class)));

        HighScores.setOnClickListener(view -> startActivity(new Intent(view.getContext(), HighScoresScreen.class)));

        LobbyB.setOnClickListener(view -> startActivity(new Intent(view.getContext(), LobbyScreen.class)));
    }
}