package _sc_3.Tetris.friends;

import _sc_3.Tetris.Utils;
import _sc_3.Tetris.sessions.SessionService;
import _sc_3.Tetris.users.AdminUserDto;
import _sc_3.Tetris.users.User;
import _sc_3.Tetris.users.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@RestController
public class FriendController {
    @Autowired
    FriendService friendService;
    @Autowired
    SessionService sessionService;

    /**
     * Adds a friendship between two users.
     * @param token Token of the first user.
     * @param friend token of the second user.
     */
    @PostMapping(path = "/friend/{token}")
    void addFriend(@PathVariable int token, @RequestBody UserDto friend){
        sessionService.getUserByToken(token)
                .map(User::getUsername)
                .ifPresent(
                        user -> friendService.addFriend(user, friend.getUsername())
                );
    }

    /**
     * Returns a list of the friends of a given user.
     * @param token Token of the user.
     * @return List of UserDto A list of the user's friends.
     */
    @GetMapping(path = "/friend/{token}")
    List<UserDto> getFriends(@PathVariable int token){
        return sessionService.getUserByToken(token)
                .map(user ->
                        user.getFriends()
                        .stream()
                        .map(UserDto::new)
                        .collect(Collectors.toList())
                )
                .orElse(null);
    }

    /**
     * Removes friendship between two users. Does nothing if the either of the users does not exist, or if they are not friends.
     * @param token Token of the first user.
     * @param friend UserDto Username of the second user.
     */
    @DeleteMapping(path = "/friend/{token}")
    void removeFriend(@PathVariable int token, @RequestBody UserDto friend){
        sessionService.getUserByToken(token)
                .map(User::getUsername)
                .ifPresent(
                        user -> friendService.removeFriend(user, friend.getUsername())
                );
    }

    /**
     * Adds a friend relation between two users.
     * @param adminPassword String Admin password.
     * @param username String Username of the first user.
     * @param friend UserDto Username of the second user.
     */
    @PostMapping(path = "/admin/{adminPassword}/friend/{username}")
    void adminAddFriend(@PathVariable String adminPassword, @PathVariable String username, @RequestBody UserDto friend){
        if (!Objects.equals(adminPassword, Utils.ADMIN_PASSWORD)) return;
        friendService.addFriend(username, friend.getUsername());
    }

    /**
     * Returns all the friends of a user.
     * @param adminPassword String Admin password.
     * @param username String Username.
     * @return List of AdminUserDto A list of the friends of the user.
     */
    @GetMapping(path = "/admin/{adminPassword}/friend/{username}")
    List<AdminUserDto> adminGetFriends(@PathVariable String adminPassword, @PathVariable String username){
        if (!Objects.equals(adminPassword, Utils.ADMIN_PASSWORD)) return null;
        return friendService.getFriends(username)
                .map(users -> users.stream()
                        .map(AdminUserDto::new)
                        .collect(Collectors.toList())
                )
                .orElse(null);
    }

    /**
     * Remove a friendship between two users.
     * @param adminPassword String Admin password.
     * @param username String Username of first user.
     * @param friend UserDto Username of second user.
     */
    @DeleteMapping(path = "/admin/{adminPassword}/friend/{username}")
    void adminRemoveFriend(@PathVariable String adminPassword, @PathVariable String username, @RequestBody UserDto friend){
        if (!Objects.equals(adminPassword, Utils.ADMIN_PASSWORD)) return;
        friendService.removeFriend(username, friend.getUsername());
    }
}
