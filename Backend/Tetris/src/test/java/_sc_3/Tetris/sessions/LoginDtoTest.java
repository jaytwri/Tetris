package _sc_3.Tetris.sessions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginDtoTest {

    @Test
    void getUsername() {
        LoginDto l = new LoginDto();
        l.setUsername("s");
        assertEquals(l.getUsername(), "s");
    }

    @Test
    void getPassword() {
        LoginDto l = new LoginDto();
        l.setPassword("s");
        assertEquals(l.getPassword(), "s");
    }

    @Test
    void setUsername() {
        LoginDto l = new LoginDto();
        l.setUsername("s");
        assertEquals(l.getUsername(), "s");
    }

    @Test
    void setPassword() {
        LoginDto l = new LoginDto();
        l.setPassword("s");
        assertEquals(l.getPassword(), "s");
    }
}