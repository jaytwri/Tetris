package _sc_3.Tetris.settings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserSettingsDtoTest {

    @Test
    void getSpeedOfBlocks() {
        UserSettingsDto s = new UserSettingsDto(1, "a");
        assertEquals(s.getSpeedOfBlocks(), 1);
    }

    @Test
    void getBoardColour() {
        UserSettingsDto s = new UserSettingsDto(1, "a");
        assertEquals(s.getBoardColour(), "a");
    }

    @Test
    void setSpeedOfBlocks() {
        UserSettingsDto s = new UserSettingsDto(1, "a");
        s.setSpeedOfBlocks(2);
        assertEquals(s.getSpeedOfBlocks(), 2);
    }

    @Test
    void setBoardColour() {
        UserSettingsDto s = new UserSettingsDto(1, "a");
        s.setBoardColour("b");
        assertEquals(s.getBoardColour(), "b");
    }
}