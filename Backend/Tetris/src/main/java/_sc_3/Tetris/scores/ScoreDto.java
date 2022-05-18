package _sc_3.Tetris.scores;

import _sc_3.Tetris.users.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author Jay Tiwari
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScoreDto {
    int score;
    UserDto user;
}
