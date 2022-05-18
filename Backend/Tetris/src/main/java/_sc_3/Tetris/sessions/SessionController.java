package _sc_3.Tetris.sessions;

import _sc_3.Tetris.users.User;
import _sc_3.Tetris.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class SessionController {

	@Autowired
	SessionService sessionService;
	@Autowired
	UserService userService;

	/**
	 * This logs a user in and returns a token which will be valid for 24 hours from log in time. This token will be used in other api calls to verify the identity of the user.
	 * @param loginDto LoginDto containing the username and password of the account to be logged in.
	 * @return TokenDto containing the session token.
	 */
	@PostMapping(path = "/session")
	TokenDto logIn(@RequestBody LoginDto loginDto) {
		Optional<User> user = userService.usernameToUser(loginDto.getUsername());
		return user.map(x -> sessionService.createSession(x))
				.map(x -> new TokenDto(x.getToken()))
				.orElse(null);
	}

	/**
	 * This invalidates a currently valid log in token. Entering an invalid token will do nothing.
	 * @param token int token to be invalidated.
	 */
	@PutMapping(path = "/session/{token}")
	void log0ut(@PathVariable int token){
		sessionService.clearSession(new TokenDto(token));
	}
}
