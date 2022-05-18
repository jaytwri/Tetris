package com.example.tetrisgame.dto;

import android.service.controls.templates.TemperatureControlTemplate;

import com.example.tetrisgame.app.LoginSession;
import com.example.tetrisgame.app.TetrisGame;

public class BoardStateDto {
    String username;
    boolean[][] board;
    int[][] fallingPairs;
    char fallingType;

    public BoardStateDto(TetrisGame game){
        username = LoginSession.getInstance().getUsername();
        fallingType = game.fallingPiece.getPieceType();
        fallingPairs = new int[4][2];
        TetrisGame.pair[] pairs = game.fallingPiece.getPairs();
        for (int i = 0; i < 4; i++){
            fallingPairs[i][0] = pairs[i].getX();
            fallingPairs[i][1] = pairs[i].getY();
        }
        board = new boolean[10][20];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                board[j][i] = (game.board[j][i] != null);
            }
        }
    }

    public BoardStateDto() {
    }

    public boolean[][] getBoard() {
        return board;
    }

    public void setBoard(boolean[][] board) {
        this.board = board;
    }

    public int[][] getFallingPairs() {
        return fallingPairs;
    }

    public void setFallingPairs(int[][] fallingPairs) {
        this.fallingPairs = fallingPairs;
    }

    public char getFallingType() {
        return fallingType;
    }

    public void setFallingType(char fallingType) {
        this.fallingType = fallingType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
