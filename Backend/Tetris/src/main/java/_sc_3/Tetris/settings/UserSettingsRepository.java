package _sc_3.Tetris.settings;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserSettingsRepository extends JpaRepository<UserSettings, Integer> {

    /**
     * This method looks for the user settings of the wanted user by their usedId
     * @param userId
     * @return Score for that particular user.
     */
    Optional<UserSettings> findById(int userId);

    /**
     * This method deletes the user settings for the user you want by looking in the repository using the userId.
     * @param userId
     */
    @Transactional
    void deleteById(int userId);


}
