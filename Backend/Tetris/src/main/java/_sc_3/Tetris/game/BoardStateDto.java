package _sc_3.Tetris.game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class BoardStateDto {
    boolean[][] board;
    int[][] fallingPairs;
    char fallingType;
}
