package mk.ukim.finki.codecamp.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 500)
    private String videoUrl;

    @Column(length = 500)
    private String description;

    public Lecture(String title, String videoUrl, String description) {
        this.title = title;
        this.videoUrl = videoUrl;
        this.description = description;
    }

    public Lecture() {
    }
}
