package _sc_3.Tetris.scores;

import _sc_3.Tetris.users.UserDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreDtoTest {

    @Test
    void getScore() {
        ScoreDto s = new ScoreDto(1, new UserDto("a"));
        assertEquals(s.getScore(), 1);
    }

    @Test
    void getUser() {
        ScoreDto s = new ScoreDto(1, new UserDto("a"));
        assertEquals(s.getUser().getUsername(), new UserDto("a").getUsername());
    }

    @Test
    void setScore() {
        ScoreDto s = new ScoreDto(1, new UserDto("a"));
        s.setScore(2);
        assertEquals(s.getScore(), 2);
    }

    @Test
    void setUser() {
        ScoreDto s = new ScoreDto(1, new UserDto("a"));
        s.setUser(new UserDto("b"));
        assertEquals(s.getUser().getUsername(), new UserDto("b").getUsername());
    }
}