package _sc_3.Tetris.sessions;

import _sc_3.Tetris.users.User;
import _sc_3.Tetris.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;


/**
 * @author Jesse Slater
 */
@Service
public class SessionService {
    @Autowired
    SessionRepository sessionRepository;
    @Autowired
    UserRepository userRepository;

    /**
     * Accepts a session token and returns a user if it is valid. Deletes the token from the database if it is invalid.
     * :@param token: Session token
     * @return User or nothing
     */
    public Optional<User> getUserByToken(TokenDto token){
        Optional<Session> s = sessionRepository.findById(token.getToken());
        if (s.isPresent() && s.get().getValidThru().isAfter(Instant.now())) {
            return Optional.of(s.get().getUser());
        } else {
            clearSession(token);
            return Optional.empty();
        }
    }
    public Optional<User> getUserByToken(int token){
        return getUserByToken(new TokenDto(token));
    }

    /**
     * Create a session token, i.e. log in
     * Token will be valid for 24 hours
     * If the user already has a token, then the existing token will be returned.
     * @param user
     * @return new token, or existing token if they have one
     */
    public Session createSession(User user) {
        Optional<Boolean> loggedIn = user.getNonNullSession()
                .map(this::sessionValid);
        if (loggedIn.isPresent() && loggedIn.get()){
            return user.getSession(); //If the user already had a token, return it
        }
        Session s = new Session(user);
        user.setSession(s);
        return sessionRepository.save(s);
    }

    /**
     * Remove a session token, i.e. log out. Cleans up after itself
     * @param token
     */
    public void clearSession(TokenDto token) {
        sessionRepository.findById(token.getToken())
                .ifPresent(this::clearSession);
    }


    /**
     * Remove a session, i. e. log out. Cleans up after itself
     * @param session
     */
    public void clearSession(Session session) {
        session.getUser().setSession(null);
        sessionRepository.delete(session);
    }
    /**
     * Clears database of sessions that did not get removed
     * Automatically called once an hour
     */
    @Scheduled(fixedRate = 60 * 60 * 1000)
    public void purgeTokens(){
        for (Session s : sessionRepository.findAll()){
            if (!sessionValid(s)) clearSession(s);
        }
    }

    /**
     * Checks if the given session is valid, and deletes it if it is not
     */
    public boolean sessionValid(Session session){
        boolean valid = session.getValidThru().isBefore(Instant.now());
        if (!valid) clearSession(session);
        return valid;
    }

    /**
     * Checks if the given token is valid, and deletes it if it is not
     */
    public boolean sessionValid(TokenDto token){
        Optional<Session> s = sessionRepository.findById(token.getToken());
        return s.isPresent() && sessionValid(s.get());
    }
}
