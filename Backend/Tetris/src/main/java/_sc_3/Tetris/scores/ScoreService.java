package _sc_3.Tetris.scores;


import _sc_3.Tetris.users.UserDto;
import _sc_3.Tetris.users.UserRepository;
import _sc_3.Tetris.users.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Service
public class ScoreService {

@Autowired
UserService userService;

    /**
     * This method changes a score object to a ScoreDto by instantiating a new ScoreDto object.
     * @param score
     * @return A new ScoreDto object
     */
    public Optional<ScoreDto> ScoreToScoreDto(Score score){
        return userService.usernameToUser(score.getUser().getUsername()).map(user ->
                new ScoreDto(score.getScore(), new UserDto(user)));

    }

}
