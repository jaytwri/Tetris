package _sc_3.Tetris.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter @NoArgsConstructor
public class AdminUserDto {
    private String username;
    private String password;
    private Date accountCreationTime;

    /**
     * This is a constructor that initializes all the instance variables using the user as a parameter.
     * @param user
     */
    public AdminUserDto(User user){
        username = user.getUsername();
        password = user.getPassword();
        accountCreationTime = user.getAccountCreationTime();
    }
}
