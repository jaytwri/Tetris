package _sc_3.Tetris.users;

import org.apache.tomcat.jni.Time;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AdminUserDtoTest {

    @Test
    void getUsername() {
        AdminUserDto adminUserDto = new AdminUserDto();
        adminUserDto.setUsername("a");
        assertEquals(adminUserDto.getUsername(), "a");
    }

    @Test
    void getPassword() {
        AdminUserDto adminUserDto = new AdminUserDto();
        adminUserDto.setPassword("a");
        assertEquals(adminUserDto.getPassword(), "a");
    }

    @Test
    void getAccountCreationTime() {
        AdminUserDto adminUserDto = new AdminUserDto();
        adminUserDto.setAccountCreationTime(new Date());
        assertEquals(adminUserDto.getAccountCreationTime().getDate(), new Date().getDate());
    }

    @Test
    void setUsername() {
        AdminUserDto adminUserDto = new AdminUserDto();
        adminUserDto.setUsername("a");
        assertEquals(adminUserDto.getUsername(), "a");
    }

    @Test
    void setPassword() {
        AdminUserDto adminUserDto = new AdminUserDto();
        adminUserDto.setPassword("a");
        assertEquals(adminUserDto.getPassword(), "a");
    }

    @Test
    void setAccountCreationTime() {
        AdminUserDto adminUserDto = new AdminUserDto();
        adminUserDto.setUsername("a");
        assertEquals(adminUserDto.getUsername(), "a");
    }
}