package _sc_3.Tetris.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

	/**
	 * This method looks for the user of user by their usedId
	 * @param Id
	 * @return Score for that particular user.
	 */
	Optional<User> findById(int Id);

	/**
	 * This method deletes the user you want by looking in the repository using the userId.
	 * @param id
	 */
	@Transactional
	void deleteById(int id);
}
