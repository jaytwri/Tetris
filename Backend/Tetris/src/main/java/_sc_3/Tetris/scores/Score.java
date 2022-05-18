package _sc_3.Tetris.scores;

import _sc_3.Tetris.users.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @Author Jay Tiwari
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Score {

    @Id @GeneratedValue
    private int generatedId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    private int score;
    /**
     * This is an all argument's constructor that initializes required values to instance variables
     *
     * @param score
     */
    public Score(User u, int score) {
        user = u;
        user.setUserId(u.getUserId());
        this.score = score;

    }






}
