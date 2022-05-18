package _sc_3.Tetris.settings;


import _sc_3.Tetris.scores.ScoreRepository;
import _sc_3.Tetris.sessions.SessionRepository;
import _sc_3.Tetris.sessions.SessionService;
import _sc_3.Tetris.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserSettingsController {

    @Autowired
    ScoreRepository scoreRepository;

    @Autowired
    UserRepository UserRepository;

    @Autowired
    SessionRepository SessionRepository;

    @Autowired
    SessionService sessionService;

    @Autowired
    UserSettingsRepository userSettingsRepository;

    /**
     * This method returns all the rows in the user settings table.
     * @return Returns a list of all user settings for all users.
     */
    @GetMapping(path = "/settings")
    List<UserSettings> getAllUsersSettings(){
        return userSettingsRepository.findAll();
    }

    /**
     * This method gives the required users settings by searching through the repository using the loginToken.
     * @param loginToken
     * @return Returns the user settings for the user wanted.
     */
    @GetMapping(path = "/settings/{loginToken}")
    Optional<UserSettings> getOneUsersSettings(@PathVariable int loginToken){
        return userSettingsRepository.
                findById(sessionService.getUserByToken(loginToken).get().getUserId());
    }

    /**
     * This method updates the database by posting the required user's user settings.
     * @param loginToken
     * @param dto
     */
    @PostMapping(path = "/settings/{loginToken}")
    UserSettings postUserSettings(@PathVariable int loginToken, @RequestBody UserSettingsDto dto){
        UserSettings userSettings = new UserSettings(sessionService.getUserByToken(loginToken)
                                .get().getUserId(),dto.getSpeedOfBlocks(),dto.getBoardColour());
        userSettingsRepository.save(userSettings);
        return userSettings;
    }

    /**
     * This method deletes the required user's user settings.
     * @param loginToken
     * @param dto
     */
    @DeleteMapping(path = "/settings/{loginToken}")
    void deleteUserSettings(@PathVariable int loginToken, @RequestBody UserSettingsDto dto){
        userSettingsRepository.deleteById(sessionService.getUserByToken(loginToken).get().getUserId());
    }

}
