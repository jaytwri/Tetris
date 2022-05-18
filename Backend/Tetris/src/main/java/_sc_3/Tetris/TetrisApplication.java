package _sc_3.Tetris;

import _sc_3.Tetris.sessions.Session;
import _sc_3.Tetris.sessions.SessionRepository;
import _sc_3.Tetris.users.User;
import _sc_3.Tetris.users.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
@EnableJpaRepositories
public class TetrisApplication {
	public static void main(String[] args) {
		SpringApplication.run(TetrisApplication.class, args);
	}

	/**
	 * Creates a few default users for testing
	 * @param userRepository
	 * @return
	 */
	@Bean
	CommandLineRunner initUser(UserRepository userRepository, SessionRepository sessionRepository) {
		return args -> {
			User user1 = new User("Jay", "1234");
			User user2 = new User("Aaron", "12345");
			User user3 = new User("Ryan", "123456");
			User user4 = new User("Shiven", "1234567");

			userRepository.save(user1);
			userRepository.save(user2);
			userRepository.save(user3);
			userRepository.save(user4);

			Session session1 = new Session(user1);
			sessionRepository.save(session1);
			Session session2 = new Session(user2);
			sessionRepository.save(session2);
			Session session3 = new Session(user3);
			sessionRepository.save(session3);


		};
	}
}