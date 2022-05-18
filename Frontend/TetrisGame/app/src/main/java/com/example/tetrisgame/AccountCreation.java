package com.example.tetrisgame;

import android.os.Bundle;
import android.util.Log;

import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tetrisgame.api.api_runner.ApiClientFactory;
import com.example.tetrisgame.api.api_runner.SlimCallback;
import com.example.tetrisgame.dto.UserCreationDto;


public class AccountCreation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_creation);
        String TAG = LoginScreen.class.getSimpleName();

        Button SignUpButton = findViewById(R.id.button2);
        TextView usernameBox = findViewById(R.id.editTextTextPersonName);
        TextView emailBox = findViewById(R.id.editTextTextPersonName2);
        TextView passwordBox = findViewById(R.id.editTextTextPersonName3);
        TextView SignUpResponse = findViewById(R.id.textView3);

        SignUpButton.setOnClickListener(view -> ApiClientFactory.GetUserApi()
                .createUser(
                    new UserCreationDto(
                            usernameBox.getText().toString(),
                            passwordBox.getText().toString()
                    )
                ).enqueue(
                    new SlimCallback<>(message -> {
                        Log.d(TAG, message.toString());
                        SignUpResponse.setText("response: " + message.toString());
                    }
                )
            )
        );
    }
}
