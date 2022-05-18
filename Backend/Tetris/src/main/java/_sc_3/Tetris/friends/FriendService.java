package _sc_3.Tetris.friends;

import _sc_3.Tetris.users.User;
import _sc_3.Tetris.users.UserRepository;
import _sc_3.Tetris.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

/**
 * @author Jesse Slater
 */
@Service
public class FriendService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    public void addFriend(String u1, String u2){
        Optional<User> user = userService.usernameToUser(u1);
        Optional<User> f = userService.usernameToUser(u2);
        if (user.isPresent() && f.isPresent())
            addFriend(user.get(), f.get());
    }
    public void addFriend(User u1, User u2){
        if (!Objects.equals(u1, u2) //Cannot be friends with one's self
                && u1.getFriends().contains(u2)) //Cannot add same friend multiple times
        {
            u1.getFriends().add(u2);
            userRepository.save(u1);
        }
    }

    public Optional<Set<User>> getFriends(String username){
        return userService.usernameToUser(username)
                .map(User::getFriends);
    }

    public void removeFriend(String u1, String u2){
        Optional<User> user = userService.usernameToUser(u1);
        Optional<User> f = userService.usernameToUser(u2);
        if (user.isPresent() && f.isPresent())
            removeFriend(user.get(), f.get());
    }
    public void removeFriend(User u1, User u2){
        u1.getFriends().remove(u2);
    }

}

