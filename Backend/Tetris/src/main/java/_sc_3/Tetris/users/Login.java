package _sc_3.Tetris.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;

/**
 *
 * @author Jay Tiwari
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class Login {

	@Id
	private String username;
	private String password;

	/**
	 * This is an all arguments constructor to initialize the private instance variables.
	 * @param username
	 * @param password
	 */
	public Login(String username, String password) {
		this.username = username;
		this.password = password;
	}

}
