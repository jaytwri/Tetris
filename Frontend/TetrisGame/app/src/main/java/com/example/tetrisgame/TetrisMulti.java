package com.example.tetrisgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
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

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Timer;
import java.util.TimerTask;

public class TetrisMulti extends AppCompatActivity {

    Button leftButton;
    Button rightButton;
    Button rotateButton;
    Button startButton;
    TextView gameBoard;
    TextView opponentBoard;
    TextView scoreBoard;
    TextView opponentScore;
    Button joinLobby;
    private WebSocketClient cc;

    TetrisGame serverGame;
    TetrisGame opponentGame;

    Timer timer;
    TimerTask timerTask;
    Boolean gameOver = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tetris_multi);

        startButton = findViewById(R.id.TetrisMulti_Start);
        gameBoard = findViewById(R.id.TetrisMulti_YourGameBoard);
        leftButton = findViewById(R.id.tetrisMulti_left);
        rightButton = findViewById(R.id.tetrisMulti_right);
        rotateButton = findViewById(R.id.tetrisMulti_rotate);
        scoreBoard = findViewById(R.id.TetrisMulti_Your_Score);
        opponentScore = findViewById(R.id.TetrisMulti_Opponent_Score);
        opponentBoard = findViewById(R.id.TetrisMulti_OpponentsGameboard);
        joinLobby = findViewById(R.id.TetrisMulti_JoinLobby);

        joinLobby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Draft[] drafts = {
                        new Draft_6455()
                };

                /**
                 * If running this on an android device, make sure it is on the same network as your
                 * computer, and change the ip address to that of your computer.
                 * If running on the emulator, you can use localhost.
                 */
                //String w = "ws://10.0.2.2:8080/chat/" + e1.getText().toString();
                String w = "ws://coms-309-037.class.las.iastate.edu:8080/game/1" ;
                try {
                    Log.d("Socket:", "Trying socket");
                    cc = new WebSocketClient(new URI(w), (Draft) drafts[0]) {
                        @Override
                        public void onMessage(String message) {
                            ObjectMapper mapper = new ObjectMapper();
                            try {
                                BoardStateDto opponentBoardState = mapper.readValue(message, BoardStateDto.class);
                                if (!opponentBoardState.getUsername().equals(LoginSession.getInstance().getUsername())) {
                                    opponentGame = new TetrisGame(opponentBoardState);
                                    CharSequence oBoard = "";
                                    for (int i = 0; i < 20; i++) {
                                        for (int j = 0; j < 10; j++) {
                                            if (opponentGame.board[j][i] != null)
                                                oBoard += "\uD83D\uDFE7";
                                            else
                                                oBoard += "\uD83D\uDFEA";
                                        }
                                        oBoard += "\n";
                                    }
                                    opponentBoard.setText(oBoard);
                                }
                            } catch (JsonProcessingException e) {
                                e.printStackTrace();
                            }
                            Log.d("", "run() returned: " + message);
                        }

                        @Override
                        public void onOpen(ServerHandshake handshake) {
                            Log.d("OPEN", "run() returned: " + "is connecting");
                        }

                        @Override
                        public void onClose(int code, String reason, boolean remote) {
                            Log.d("CLOSE", "onClose() returned: " + reason);
                        }

                        @Override
                        public void onError(Exception e) {
                            Log.d("Exception:", e.toString());
                        }
                    };
                } catch (URISyntaxException e) {
                    Log.d("Exception:", e.getMessage().toString());
                    e.printStackTrace();
                }
                cc.connect();

            }
        });

        //annoying quirk of android studio
        final TetrisGame[] game = new TetrisGame[1];

        startButton.setOnClickListener(view -> {

            game[0] = new TetrisGame();
            opponentGame = new TetrisGame();
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


                        ObjectMapper mapper = new ObjectMapper();
                        try {
                            String jsonInString = mapper.writeValueAsString(new BoardStateDto(game[0]));

                            cc.send(jsonInString);
                        } catch (JsonProcessingException e) {
                            e.printStackTrace();
                        }

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