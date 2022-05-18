package _sc_3.Tetris.sessions;

import _sc_3.Tetris.users.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Duration;
import java.time.Instant;

@Entity
@Getter @Setter @NoArgsConstructor
public class Session {
    @Id
    @GeneratedValue
    private int token;
    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;
    private Instant loggedIn;
    private Instant validThru;

    private static Duration VALID_DURATION = Duration.ofDays(1);

    public Session(User user){
        this.user = user;
        this.loggedIn = Instant.now();
        this.validThru = Instant.now().plus(VALID_DURATION);
    }
}
