package _sc_3.Tetris.lobby;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LobbyTokenDtoTest {

    @Test
    void getLobbyToken() {
        LobbyTokenDto ltd = new LobbyTokenDto();
        ltd.setLobbyToken(12);
        Assertions.assertEquals(12, ltd.getLobbyToken());
    }

    @Test
    void setLobbyToken() {
        LobbyTokenDto ltd = new LobbyTokenDto();
       ltd.setLobbyToken(12);
        Assertions.assertEquals(12,ltd.getLobbyToken());
    }
}