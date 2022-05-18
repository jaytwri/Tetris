package _sc_3.Tetris.sessions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TokenDtoTest {

    @Test
    void getToken() {
        TokenDto t = new TokenDto(1);
        assertEquals(t.getToken(), 1);
    }

    @Test
    void setToken() {
        TokenDto t = new TokenDto(1);
        t.setToken(2);
        assertEquals(t.getToken(), 2);
    }

}