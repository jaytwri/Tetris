package _sc_3.Tetris.lobby;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class LobbyTokenDto {
    private int lobbyToken;

    public LobbyTokenDto(Lobby lobby){
        lobbyToken = lobby.getLobbyToken();
    }
}
