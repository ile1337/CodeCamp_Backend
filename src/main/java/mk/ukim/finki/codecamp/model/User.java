package mk.ukim.finki.codecamp.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "courseusers")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public User() {
    }
}
