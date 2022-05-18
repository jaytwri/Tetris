package _sc_3.Tetris;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageTest {

    @Test
    void getMessage() {
        Message m = new Message("m");
        assertEquals(m.getMessage(), "m");
    }

    @Test
    void setMessage() {
        Message m = new Message("n");
        m.setMessage("m");
        assertEquals(m.getMessage(), "m");
    }
}