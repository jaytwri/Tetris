package _sc_3.Tetris.users;

import _sc_3.Tetris.Message;
import _sc_3.Tetris.Utils;
import _sc_3.Tetris.sessions.SessionRepository;
import _sc_3.Tetris.sessions.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class UserController {
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserService userService;
	@Autowired
	SessionRepository sessionRepository;
	@Autowired
	SessionService sessionService;

	/**
	 * This method saves a new user to the database using a UserCreationDto as a parameter.
	 * @param userCreationDto
	 * @return A message when a User is created successfully.
	 */
	@PostMapping(path = "/user")
	Message createUser(@RequestBody UserCreationDto userCreationDto) {
		if (userCreationDto == null) return new Message("Failed");
		userRepository.save(new User(userCreationDto));
		return new Message("User Created");
	}

	/**
	 * This method returns all users in the table.
	 * @return All the users that exist in the database.
	 */
	@GetMapping(path = "/user")
	List<UserDto> getAllUsers() {
		return userRepository.findAll()
				.stream()
				.map(UserDto::new)
				.collect(Collectors.toList());
	}

	/**
	 * This method returns the user and it's attributes by looking for them in the repository using their username
	 * @param username
	 * @return
	 */
	@GetMapping(path = "/user/{username}")
	UserDto getUserByUsername(@PathVariable String username) {
		return userService.usernameToUser(username)
				.map(UserDto::new)
				.orElse(null);
	}

	/**
	 * This method deletes the user from the database using the session token.
	 * @param token
	 */
	@DeleteMapping(path = "/user/{token}")
	void deleteUser(@PathVariable int token) {
		sessionService.getUserByToken(token)
				.ifPresent(user -> userRepository.delete(user));
	}

	/**
	 * This method returns a list of AdminUserDto by creating new instances of them.
	 * @param adminPassword
	 * @return A list of AdminUserDto
	 */
	@GetMapping(path = "/admin/{adminPassword}/user")
	List<AdminUserDto> adminGetAllUsers(@PathVariable String adminPassword){
		if (!Objects.equals(adminPassword, Utils.ADMIN_PASSWORD)) return null;
		return userRepository
				.findAll()
				.stream()
				.map(AdminUserDto::new)
				.collect(Collectors.toList());
	}

	/**
	 * This method returns the wanted user by looking for them using their username.
	 * @param adminPassword
	 * @param username
	 * @return A user
	 */
	@GetMapping(path = "/admin/{adminPassword}/user/{username}")
	User adminGetUserByUsername(@PathVariable String adminPassword, @PathVariable String username) {
		if (!Objects.equals(adminPassword, Utils.ADMIN_PASSWORD)) return null;
		return userService.usernameToUser(username)
				.orElse(null);
	}

	/**
	 * This method deletes the user from the database.
	 * @param adminPassword
	 * @param username
	 */
	@DeleteMapping(path = "/admin/{adminPassword}/user/{username}")
	void adminDeleteUser(@PathVariable String adminPassword, @PathVariable String username) {
		if (!Objects.equals(adminPassword, Utils.ADMIN_PASSWORD)) return;
		userService.usernameToUser(username)
					.ifPresent(x -> userRepository.delete(x));
	}
}
