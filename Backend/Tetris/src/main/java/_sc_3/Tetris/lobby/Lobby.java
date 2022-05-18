package _sc_3.Tetris.lobby;

import _sc_3.Tetris.users.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Lobby {
    private static int nextLobbyToken;
    private int lobbyToken;
    private List<User> users;

    protected Lobby(){
        lobbyToken = nextLobbyToken;
        nextLobbyToken += 1;
        users = new ArrayList<>();
    }

    public Lobby addUser(User user){
        users.add(user);
        return this;
    }

    public List<User> getUsers(){
        return users;
    }
}
