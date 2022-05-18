package _sc_3.Tetris.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * Data transfer object for user.
 *
 */
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class UserDto {
    private String username;

    public UserDto(User user){
        this.username = user.getUsername();
    }
}

