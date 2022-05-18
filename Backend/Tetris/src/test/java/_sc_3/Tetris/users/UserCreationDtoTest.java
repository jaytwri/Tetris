package _sc_3.Tetris.users;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserCreationDtoTest {

    @Test
    void getUsername() {
        UserCreationDto userCreationDto = new UserCreationDto("username", "password");
        assertEquals(userCreationDto.getUsername(), "username");
    }

    @Test
    void getPassword() {
        UserCreationDto userCreationDto = new UserCreationDto("username", "password");
        assertEquals(userCreationDto.getPassword(), "password");
    }

    @Test
    void setUsername() {
        UserCreationDto userCreationDto = new UserCreationDto("username", "password");
        userCreationDto.setUsername("newUsername");
        assertEquals(userCreationDto.getUsername(), "newUsername");
    }

    @Test
    void setPassword() {
        UserCreationDto userCreationDto = new UserCreationDto("username", "password");
        userCreationDto.setPassword("newPassword");
        assertEquals(userCreationDto.getPassword(), "newPassword");
    }
}