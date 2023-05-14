package mk.ukim.finki.codecamp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String videoUrl;

    private String description;

    public Lecture(String title, String videoUrl, String description) {
        this.title = title;
        this.videoUrl = videoUrl;
        this.description = description;
    }

    public Lecture() {
    }
}
