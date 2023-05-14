package mk.ukim.finki.codecamp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;

    private Long points;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Answer> providedAnswers;

    @OneToOne
    private Answer correctAnswer;

    public Question(String question, Long points) {
        this.question = question;
        this.points = points;
        this.providedAnswers = new ArrayList<>();
        this.correctAnswer = null;
    }

    public Question(String question, Long points, List<Answer> providedAnswers, Answer correctAnswer) {
        this.question = question;
        this.points = points;
        this.providedAnswers = providedAnswers;
        this.correctAnswer = correctAnswer;
    }

    public Question() {
    }
}
