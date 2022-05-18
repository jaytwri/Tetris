package _sc_3.Tetris.sessions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 *
 * @author Jesse Slater
 *
 */

public interface SessionRepository extends JpaRepository<Session, Integer> {
    Optional<Session> findById(int Token);

    @Transactional
    void deleteById(int Token);
}
