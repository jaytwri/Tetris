package com.example.tetrisgame;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;


import androidx.appcompat.app.AppCompatActivity;

import com.example.tetrisgame.api.api_runner.ApiClientFactory;
import com.example.tetrisgame.api.api_runner.SlimCallback;
import com.example.tetrisgame.app.LoginSession;
import com.example.tetrisgame.dto.UserDto;

import java.util.ArrayList;
import java.util.Optional;

public class LobbyScreen extends AppCompatActivity {


    private WebSocketClient cc;

    Button b1, b2, startGame;
    EditText e1, e2;
    TextView t1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);
        String TAG = LobbyScreen.class.getSimpleName();
/**
        Button CreateLobbyB = findViewById(R.id.CreateLobbyButton);
        Button Refresh = findViewById(R.id.RefreshButton);
        Button Join = findViewById(R.id.JoinLobbyButton);
        TextView First = findViewById(R.id.LobbyBox1);
        TextView Second = findViewById(R.id.LobbyBox2);
        TextView joinInput = findViewById(R.id.editTextTextPersonName5);
        TextView CreateOutput = findViewById(R.id.textView4);
*/
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        e2 = (EditText) findViewById(R.id.e2);
        t1 = (TextView) findViewById(R.id.t1);
        startGame = findViewById(R.id.Lobby_StartGame);




        startGame.setOnClickListener(view -> startActivity(new Intent(view.getContext(), TetrisMulti.class)));

        b1.setOnClickListener(new View.OnClickListener() {
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



                //String w = "ws://10.0.2.2:8080/websocket/" + e1.getText().toString();
                String w = "ws://coms-309-037.class.las.iastate.edu:8080/chat/" + LoginSession.getInstance().getUsername();
                ArrayList<String> messages = new ArrayList<>();

                try {
                    Log.d("Socket:", "Trying socket");
                    cc = new WebSocketClient(new URI(w), (Draft) drafts[0]) {
                        @Override
                        public void onMessage(String message) {
                            Log.d("", "run() returned: " + message);
                            messages.add(message);
                            String s = "";
                            for (int i = messages.size() - 1; i > 0; i--) {
                                if (i <= messages.size()-12){
                                    break;
                                }
                                s += "\n" + messages.get(i);
                                t1.setText(s);
                            }


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



        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    cc.send(e2.getText().toString());
                } catch (Exception e) {
                    Log.d("ExceptionSendMessage:", e.getMessage().toString());
                }
            }
        });



/**


        final int[] LobbyToken = {0};

        CreateLobbyB.setOnClickListener(view -> ApiClientFactory.GetLobbyApi()
                .createLobby(
                        LoginSession.getInstance().getToken()
                ).enqueue(
                new SlimCallback<>(LobbyTokenDto -> {
                    int t = LobbyTokenDto.getLobbyToken();
                    String text = String.valueOf(t);
                    CreateOutput.setText(text);
                    LobbyToken[0] = t;
                }

                        , "CreateLobby"
                )
        ));

        Join.setOnClickListener(view -> ApiClientFactory.GetLobbyApi()
                .joinLobby(LobbyToken[0], LoginSession.getInstance().getToken())
                        .enqueue(
                                new SlimCallback<>(optionalSetUserDto ->{
                                    
                                }, "JoinLobby"
                                )
                        )
        );



        Refresh.setOnClickListener(view -> ApiClientFactory.GetLobbyApi()
                .getUsers(
                        LobbyToken[0]
                ).enqueue(
                        new SlimCallback<>(UserDto -> {
                                First.setText(UserDto.get(0).getUsername());
                                //Second.setText(UserDto.get(1).getUsername());

                        }, "GetUsers")
                ));

        */
    }
}
