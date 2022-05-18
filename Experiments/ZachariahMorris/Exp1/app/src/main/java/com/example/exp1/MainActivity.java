package com.example.exp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = findViewById(R.id.button);
        Button clearButton = findViewById(R.id.button2);
        Button listButton = findViewById(R.id.button3);

        TextView output = findViewById(R.id.textView);
        TextView input = findViewById(R.id.textInputEditText2);

        ArrayList<String> words = new ArrayList<>();

        output.setText("");



        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                words.add(input.getText().toString());

                String temp;

                for (int x = 0; x < words.size(); x++) {
                    for (int y = x; y < words.size(); y++) {

                        if (words.get(x).compareTo(words.get(y)) > 0){
                            temp = words.get(x);
                            words.set(x, words.get(y));
                            words.set(y, temp);


                        }

                    }
                }

                output.setText("");

                for (int i = 0; i < words.size(); i++) {
                    output.setText(output.getText().toString() + words.get(i) + "\n");

                }

            }
        });

        clearButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                words.removeAll(words);


                output.setText("");



            }
        });

        listButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                words.add(input.getText().toString());

                output.setText("");

                for (int i = 0; i < words.size(); i++) {
                    output.setText(output.getText().toString() + words.get(i) + "\n");

                }



            }
        });
    }
}
