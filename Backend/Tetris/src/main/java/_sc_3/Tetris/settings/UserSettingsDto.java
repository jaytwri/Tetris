package _sc_3.Tetris.settings;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserSettingsDto {

    private int speedOfBlocks;
    private String boardColour;

}
