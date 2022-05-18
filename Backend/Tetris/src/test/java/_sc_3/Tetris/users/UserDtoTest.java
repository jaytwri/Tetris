package _sc_3.Tetris.users;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDtoTest {
    @Test
    void UserDto(){
        UserDto userDto = new UserDto("username");
        assertEquals(userDto.getUsername(), "username");
    }
    @Test
    void getUsername() {
        UserDto userDto = new UserDto("username");
        assertEquals(userDto.getUsername(), "username");
    }

    @Test
    void setUsername() {
        UserDto userDto = new UserDto("username");
        userDto.setUsername("newUsername");
        assertEquals(userDto.getUsername(), "newUsername");
    }
}