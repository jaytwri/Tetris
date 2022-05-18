package com.example.mindrupexperiment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Counter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.counter);

        Button buttonToCounter = findViewById(R.id.ActivityMain_Increment_Button);
        TextView countText = findViewById(R.id.ActivityMain_CounterText);
        Integer[] count = {0};
        Button btn = findViewById(R.id.Counter_Button_GoCalc);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), Calculator.class));
            }
        });


        buttonToCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count[0]++;
                countText.setText(count[0].toString());



            }
        });
    }
}