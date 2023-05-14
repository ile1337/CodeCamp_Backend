package mk.ukim.finki.codecamp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long completionTime;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Question> questions;

    public Quiz(Long completionTime) {
        this.completionTime = completionTime;
        this.questions = new ArrayList<>();
    }

    public Quiz(Long completionTime, List<Question> questions) {
        this.completionTime = completionTime;
        this.questions = questions;
    }

    public Quiz() {
    }

    public int getNumberOfQuestions() {
        return this.questions.size();
    }

    public int getTotalPoints() {
        return this.questions.stream().reduce(0, (total, curr) -> total + curr.getPoints().intValue(), Integer::sum);
    }
}
