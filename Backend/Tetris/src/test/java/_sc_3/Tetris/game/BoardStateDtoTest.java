package _sc_3.Tetris.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardStateDtoTest {

    @Test
    void getBoard() {
        BoardStateDto bsd = new BoardStateDto();
        boolean[][] board;
        board = new boolean[2][2];
        bsd.setBoard(board);
        Assertions.assertEquals(board, bsd.getBoard());
    }

    @Test
    void getFallingPairs() {
        BoardStateDto bsd = new BoardStateDto();
        boolean[][] board;
        board = new boolean[2][2];
        int[][] pairs;
        pairs = new int[2][2];
        bsd.setFallingPairs(pairs);
        Assertions.assertEquals(pairs,bsd.getFallingPairs());
    }

    @Test
    void getFallingType() {
        BoardStateDto bsd = new BoardStateDto();
        char fallingType = 0;
        bsd.setFallingType(fallingType);
        Assertions.assertEquals(0,bsd.getFallingType());

    }

    @Test
    void setBoard() {
        BoardStateDto bsd = new BoardStateDto();
        boolean[][] board;
        board = new boolean[2][2];
        bsd.setBoard(board);
        Assertions.assertEquals(bsd.getBoard(), board);

    }

    @Test
    void setFallingPairs() {
        BoardStateDto bsd = new BoardStateDto();
        boolean[][] board;
        board = new boolean[2][2];
        int[][] pairs;
        pairs = new int[2][2];
        bsd.setFallingPairs(pairs);
        Assertions.assertEquals(pairs,bsd.getFallingPairs());
    }

    @Test
    void setFallingType() {
        BoardStateDto bsd = new BoardStateDto();
        char fallingType = 0;
        bsd.setFallingType(fallingType);
        Assertions.assertEquals(0,bsd.getFallingType());
    }
}