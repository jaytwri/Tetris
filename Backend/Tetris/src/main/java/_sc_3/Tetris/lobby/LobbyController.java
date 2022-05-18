package _sc_3.Tetris.lobby;

import _sc_3.Tetris.Message;
import _sc_3.Tetris.sessions.SessionService;
import _sc_3.Tetris.users.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LobbyController {
    @Autowired LobbyService lobbyService;
    @Autowired SessionService sessionService;

    /**
     * Creates a new lobby and adds the given user to it. Returns the token of the lobby.
     * @param token int Token of the user to be added.
     * @return LobbyTokenDto Token of the lobby.
     */
    @GetMapping(path = "/lobby/create/{token}")
    LobbyTokenDto createLobby(@PathVariable int token){
        return sessionService
                .getUserByToken(token)
                .map(user -> lobbyService
                        .createLobby()
                        .addUser(user)
                )
                .map(LobbyTokenDto::new)
                .orElse(null);
    }

    /**
     * Adds a user to a lobby. Returns the token of the lobby if successful, or null if the lobbyToken is invalid, or the session is invalid
     * @param lobbyToken int Token of the lobby.
     * @param token int Token of the user to be added.
     * @return LobbyTokenDto Token of the lobby.
     */
    @GetMapping(path = "/lobby/join/{lobbyToken}/{token}")
    LobbyTokenDto joinLobby(@PathVariable int lobbyToken, @PathVariable int token){
        return lobbyService
                .getLobby(new LobbyTokenDto(lobbyToken))
                .flatMap(lobby -> sessionService
                        .getUserByToken(token)
                        .map(user -> new LobbyTokenDto(lobby.addUser(user)))
                )
                .orElse(null);
    }

    /**
     * Returns a list of the users in a lobby. Returns null if lobby is empty or if lobby token is invalid.
     * @param lobbyToken int Token of the lobby.
     * @return List of UserDto List of the userDtos of the users in the lobby.
     */
    @GetMapping(path = "/lobby/{lobbyToken}")
    List<UserDto> getUsers(@PathVariable int lobbyToken){
        return lobbyService.getLobby(new LobbyTokenDto(lobbyToken))
                .map(lobby -> lobby.getUsers()
                        .stream()
                        .map(UserDto::new)
                        .collect(Collectors.toList())
                )
                .orElse(null);
    }

    /**
     * Deletes a lobby. Removes players from lobby, if anyone is in it.
     * @param lobbyToken int Token of the lobby to be removed.
     * @return Message : "Required lobby has been closed."
     */
    @DeleteMapping(path="/lobby/{lobbyToken}")
    Message deleteLobby(@PathVariable int lobbyToken){
        lobbyService.getLobby(new LobbyTokenDto(lobbyToken))
                .ifPresent(lobby -> lobbyService.closeLobby(lobby));
        return new Message("Required lobby has been closed.");
    }
}
