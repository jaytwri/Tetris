package com.example.tetrisgame;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tetrisgame.api.api_runner.ApiClientFactory;
import com.example.tetrisgame.api.api_runner.SlimCallback;
import com.example.tetrisgame.app.LoginSession;
import com.example.tetrisgame.app.TetrisGame;
import com.example.tetrisgame.dto.BoardStateDto;
import com.example.tetrisgame.dto.ScoreDto;
import com.example.tetrisgame.dto.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Timer;
import java.util.TimerTask;

public class TetrisSingle extends AppCompatActivity {

    Button leftButton;
    Button rightButton;
    Button rotateButton;
    Button startButton;
    TextView gameBoard;
    TextView scoreBoard;


    TetrisGame serverGame;

    Timer timer;
    TimerTask timerTask;
    Boolean gameOver = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tetris_single);



        startButton = findViewById(R.id.TetrisSingle_start);
        gameBoard = findViewById(R.id.TetrisSingle_GameBoard);
        leftButton = findViewById(R.id.TetrisSingle_left);
        rightButton = findViewById(R.id.TetrisSingle_right);
        rotateButton = findViewById(R.id.TetrisSingle_rotate);
        scoreBoard = findViewById(R.id.TetrisSingle_Score);



        //annoying quirk of android studio
        final TetrisGame[] game = new TetrisGame[1];
        /*
        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonInString = mapper.writeValueAsString(new BoardStateDto());
            gameBoard.setText(jsonInString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        */
        startButton.setOnClickListener(view -> {
            game[0] = new TetrisGame();
            timer = new Timer();
            timerTask = new TimerTask() {
                @Override
                public void run() {
                    if(!gameOver) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                CharSequence score = "Score: " + game[0].score;

                                scoreBoard.setText(score);
                            }
                        });

                        runGame(game[0]);
                        CharSequence board = "";
                        for (int i = 0; i < 20; i++) {
                            for (int j = 0; j < 10; j++) {
                                if (game[0].board[j][i] != null)
                                    board += "\uD83D\uDFE7";
                                else
                                    board += "\uD83D\uDFEA";
                            }
                            board += "\n";
                        }
                        gameBoard.setText(board);
                        if (!game[0].fallingPiece.canMoveDown()) {
                            game[0].clearLines();
                            if (!game[0].spawnPiece()) {
                                gameOver = true;

                            }
                        }
                        ApiClientFactory.GetGameApi()
                                .postGameState(LoginSession.getInstance().getToken(), new BoardStateDto(game[0]))
                                .enqueue(new SlimCallback<>(x -> {}));
                        ApiClientFactory.GetGameApi()
                                .getLastGameState(LoginSession.getInstance().getToken())
                                .enqueue(new SlimCallback<>(x -> {
                                    serverGame = new TetrisGame(x);
                                }));
                    }
                    else {
                        ApiClientFactory.GetScoreApi()
                                .postScore(
                                        LoginSession.getInstance().getToken(),
                                        new ScoreDto(
                                                game[0].score, new UserDto(LoginSession.getInstance().getUsername())
                                        )
                                )
                                .enqueue(new SlimCallback<>(x -> {}));
                        timerTask.cancel();
                    }
                }
            };
            timer.scheduleAtFixedRate(timerTask, 17, 510);

        });

        rightButton.setOnClickListener(view -> game[0].setRPress(true));
        leftButton.setOnClickListener(view -> game[0].setLPress(true));
        rotateButton.setOnClickListener(view -> game[0].setUPress(true));
    }

    public void runGame(TetrisGame game)
    {
        int count = 0;
        while(count < 10)
        {

            if(game.lPress)
            {
                game.fallingPiece = game.fallingPiece.moveL();
                count = 0;
            }
            else if(game.rPress)
            {
                game.fallingPiece = game.fallingPiece.moveR();
                count = 0;
            }
            else if(game.uPress)
            {
                game.fallingPiece = game.fallingPiece.rotatePiece();
                count = 0;
            }
            else {
                count++;
            }
        }
        game.fallingPiece = game.fallingPiece.moveD();
    }


}