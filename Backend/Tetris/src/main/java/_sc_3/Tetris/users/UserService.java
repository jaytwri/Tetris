package _sc_3.Tetris.users;

import _sc_3.Tetris.sessions.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    SessionService sessionService;

    /**
     * This method creates a new user using their username.
     * @param name
     * @return User created.
     */
    public Optional<User> usernameToUser(String name){
        for (User user : userRepository.findAll()){
            if (user.getUsername().equals(name)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    /**
     * Checks if a user is already logged in.
     * @param user
     * @return boolean value
     */
    public boolean isLoggedIn(User user){
        return user.getNonNullSession().map(s -> sessionService.sessionValid(s))
                .orElse(false);
    }
}

