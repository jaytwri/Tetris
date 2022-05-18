package _sc_3.Tetris.scores;

import _sc_3.Tetris.Message;
import _sc_3.Tetris.sessions.Session;
import _sc_3.Tetris.sessions.SessionRepository;
import _sc_3.Tetris.sessions.SessionService;
import _sc_3.Tetris.users.User;
import _sc_3.Tetris.users.UserRepository;
import _sc_3.Tetris.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Author Jay Tiwari
 */
@RestController
public class ScoreController {

    @Autowired
    ScoreRepository scoreRepository;

    @Autowired
    UserRepository UserRepository;

    @Autowired
    SessionRepository SessionRepository;

    @Autowired
    SessionService sessionService;

    @Autowired
    ScoreService scoreService;

    @Autowired
    UserService userService;

    private String success = "{\"message\":\"success\"}";
    private String failure = "{\"message\":\"failure\"}";


    /**
     * This method returns all scores that are saved to the database linked with a userId.
     * @return Returns a list of scores.
     */
    @GetMapping(path = "/score")
    List<ScoreDto> getAllScores() {
        return scoreRepository.findAll()
                .stream()//stream contains scores
                .map(score -> scoreService.ScoreToScoreDto(score))//scream contains Optional<ScoreDto>;
                .filter(Optional::isPresent) //stream contains Optional<ScoreDto>, and all are present
                .map(Optional::get) //stream contains ScoreDto
                .collect(Collectors.toList());
    }

    /**
     * This method allows adding a score to the database after a game is over according to the user's login token.
     * @param loginToken
     * @param highscoresDto
     * @return Returns a message when the required score is added successfully.
     */
    @PostMapping(path = "/score/{loginToken}")
    Message postScore(@PathVariable int loginToken,@RequestBody ScoreDto highscoresDto) {
        Optional<Session> s = SessionRepository.findById(loginToken);
        Optional<User> u = Optional.ofNullable(s.get().getUser());
        Score h = new Score(u.get(), highscoresDto.getScore());
        scoreRepository.save(h);
        return new Message("Highscore added");
    }

    /**
     * Removes a score from the database using the users login token.
     * @param loginToken
     * @return A message when the score is deleted successfully.
     */
    @DeleteMapping(path = "/score/{loginToken}")
    Message deleteScore(@PathVariable int loginToken){
        Optional<Session> currentUserSession = SessionRepository.findById(loginToken);
        User currentUser = currentUserSession.get().getUser();
        scoreRepository.deleteById(currentUser.getUserId());
        return new Message("Deleted score");
    }

}

