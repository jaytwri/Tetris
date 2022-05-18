package _sc_3.Tetris.lobby;


import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public class LobbyService {
    private HashMap<Integer, Lobby> openLobbies = new HashMap<>();

    public Lobby createLobby(){
        Lobby ret = new Lobby();
        openLobbies.put(ret.getLobbyToken(), ret);
        return ret;
    }

    public void closeLobby(Lobby lobby){
        openLobbies.remove(lobby.getLobbyToken());
    }

    public Optional<Lobby> getLobby(LobbyTokenDto lobbyTokenDto){
        return (openLobbies.containsKey(lobbyTokenDto.getLobbyToken())
                ? Optional.of(openLobbies.get(lobbyTokenDto.getLobbyToken()))
                : Optional.empty());
    }
}
