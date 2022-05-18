package com.example.tetrisgame;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tetrisgame.api.api_runner.ApiClientFactory;
import com.example.tetrisgame.api.api_runner.SlimCallback;
import com.example.tetrisgame.dto.ScoreDto;

import android.widget.Button;

import java.util.Collections;
import java.util.Comparator;

public class HighScoresScreen extends AppCompatActivity {
/**
    class ScoreComparator implements Comparator<ScoreDto> {
        @Override
        public int compare(ScoreDto a, ScoreDto b) {
            return a.getScore() < b.getScore() ? -1 : a.getScore() == b.getScore() ? 0 : 1;
        }
    }

    */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_scores);
        String TAG = HighScoresScreen.class.getSimpleName();


        TextView thirdUser = findViewById(R.id.ThirdUser);
        TextView thirdScore = findViewById(R.id.ThirdScoreBox);

        TextView SecondUser = findViewById(R.id.SecondUser);
        TextView SecondScore = findViewById(R.id.SecondScoreBox);

        TextView FirstUser = findViewById(R.id.FirstUser);
        TextView FirstScore = findViewById(R.id.BestScoreBox);

        Button BackButton = findViewById(R.id.ScoresBackButton);


/*
        int best = 23;


        String bestScore =  String.valueOf(best);
        int secondBestScore = 4;
        int thirdBestScore = 65;
        FirstScore.setText(bestScore);
        SecondScore.setText(FirstScore.getText().toString());



*/

        BackButton.setOnClickListener(view -> {
            ApiClientFactory.GetScoreApi().getAllScores(

            ).enqueue(
                    new SlimCallback<>((ScoreDto -> {
                        int bestScore = 0;
                        int secondBestScore = 0;
                        int thirdBestScore = 0;


                        String best;
                        String second;
                        String third;

                        Collections.sort(ScoreDto, (a, b) -> Integer.compare(a.getScore(), b.getScore()));


                        thirdBestScore = ScoreDto.get(ScoreDto.size()-3).getScore();
                        third = String.valueOf(thirdBestScore);

                        //thirdUser.setText(ScoreDto.get(2).getUser().getUsername());

                        secondBestScore = ScoreDto.get(ScoreDto.size()-2).getScore();
                        second = String.valueOf(secondBestScore);


                        bestScore = ScoreDto.get(ScoreDto.size()-1).getScore();
                        best = String.valueOf(bestScore);









                        // FirstUser.setText(second);


                        thirdScore.setText(best);
                        SecondScore.setText(second);
                        FirstScore.setText(third);

                        FirstUser.setText(ScoreDto.get(ScoreDto.size()-3).getUser().getUsername());
                        SecondUser.setText(ScoreDto.get(ScoreDto.size()-2).getUser().getUsername());
                        thirdUser.setText(ScoreDto.get(ScoreDto.size()-1).getUser().getUsername());


                        //  SecondUser.setText(ScoreDto.get(1).getUser().getUsername().toString());
                        //  SecondScore.setText(secondBestScore);

                        //  thirdUser.setText(ScoreDto.get(2).getUser().getUsername());
                        // thirdScore.setText(thirdBestScore);
/**

                        for (int i = 0; i < ScoreDto.size(); i++) {
                            if (ScoreDto.get(i).getScore() >= bestScore) {
                                third = String.valueOf(thirdBestScore);
                                thirdBestScore = secondBestScore;
                                second = String.valueOf(secondBestScore);
                                secondBestScore = bestScore;
                                best =  String.valueOf(bestScore);
                                bestScore = ScoreDto.get(i).getScore();

                                thirdUser.setText(SecondUser.getText().toString());
                                thirdScore.setText(third);

                                SecondUser.setText(FirstUser.getText().toString());
                                SecondScore.setText(second);

                                FirstUser.setText(ScoreDto.get(i).getUser().getUsername());
                                FirstScore.setText(best);


                            }
                            else if (ScoreDto.get(i).getScore() >= secondBestScore){
                                third = String.valueOf(thirdBestScore);
                                thirdBestScore = secondBestScore;
                                second = String.valueOf(secondBestScore);
                                secondBestScore = ScoreDto.get(i).getScore();

                                thirdUser.setText(SecondUser.getText().toString());
                                thirdScore.setText(third);

                                SecondUser.setText(ScoreDto.get(i).getUser().getUsername());
                                SecondScore.setText(second);
                            }

                            else if (ScoreDto.get(i).getScore() >= thirdBestScore){
                                third = String.valueOf(thirdBestScore);
                                thirdBestScore = ScoreDto.get(i).getScore();

                                thirdUser.setText(ScoreDto.get(i).getUser().getUsername());
                                thirdScore.setText(third);


                            }


                        }
*/
                    }), "GetAllScores"));
        });



        //BackButton.setOnClickListener(view -> startActivity(new Intent(view.getContext(), MainActivity.class)));


               /*
               .enqueue(
                new SlimCallback<>((scoreDto-> {
                    loginResponse.setText("Logged In! Token : " + tokenDto.getToken() + "Password : " + passwordField.getText().toString());
                    LoginSession.getInstance()
                            .setToken(tokenDto.getToken());
                }))
        );

                */
    }

}
