package _sc_3.Tetris.scores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @Author Jay Tiwari
 */
public interface ScoreRepository extends JpaRepository<Score, Integer> {

    /**
     * This method looks for the Scores of user by their usedId
     * @param userId
     * @return Score for that particular user.
     */
    Optional<Score> findById(Integer userId);

    /**
     * This method deletes the score for the user you want by looking in the repository using the userId.
     * @param userId
     */
    @Transactional
    void deleteById(Integer userId);

}
