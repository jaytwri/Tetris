package _sc_3.Tetris.game;

import _sc_3.Tetris.sessions.SessionService;
import _sc_3.Tetris.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GameController {
    @Autowired SessionService sessionService;

    /**
     * Returns the last game state that a user sent to the server. If the user has never played a game or if the session token is invalid, returns null.
     * @param token int User's session token.
     * @return BoardStateDto The last board state the user sent to the server.
     */
    @GetMapping(path = "/game/{token}")
    BoardStateDto getLastGameState(@PathVariable int token){
        return sessionService.getUserByToken(token)
                .map(User::getLastBoardState)
                .orElse(null);
    }

    /**
     * Saves a board state played by a user. Only one board state is ever saved, so this overwrites the previous board state that was sent.
     * @param token int User's session token.
     * @param boardState BoardStateDto Board state to be posted.
     */
    @PostMapping("/game/{token}")
    void postGameState(@PathVariable int token, @RequestBody BoardStateDto boardState){
        sessionService.getUserByToken(token)
                .ifPresent(user ->
                        user.setLastBoardState(boardState)
                );
    }
}
