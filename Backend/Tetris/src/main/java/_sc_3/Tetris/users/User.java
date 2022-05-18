package _sc_3.Tetris.users;

import _sc_3.Tetris.game.BoardStateDto;
import _sc_3.Tetris.scores.Score;
import _sc_3.Tetris.sessions.Session;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 *
 * @author Jay Tiwari
 *
 */

@Entity
@Getter @Setter @NoArgsConstructor
public class User {

	@OneToMany
	private Set<Score> scores;

	@Id
	@GeneratedValue
	private int userId;
	private String username;
	private String password;
	private Date accountCreationTime;
	@Transient //TODO this does not work at all because this is transient, I just don't know how to fix it otherwise.
	private BoardStateDto lastBoardState;
	@Nullable
	@OneToOne(mappedBy = "user")
	private Session session;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="friends_with",
			joinColumns={@JoinColumn(name="person_id")},
			inverseJoinColumns={@JoinColumn(name="friend_id")})
	@JsonIgnore
	private Set<User> friends = new HashSet<>();

	@ManyToMany(mappedBy="friends")
	@JsonIgnore
	private Set<User> friendsOf = new HashSet<>();

	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.accountCreationTime = Date.from(Instant.now());
		this.session = null;
	}

	public User(UserCreationDto userCreationDto){
		this(userCreationDto.getUsername(), userCreationDto.getPassword());
	}
	@JsonIgnore
	public Optional<Session> getNonNullSession(){
		return Optional.ofNullable(getSession());

	}
}

