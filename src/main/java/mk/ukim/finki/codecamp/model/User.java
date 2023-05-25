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

    private String username;

    private String password;

    @Enumerated(value = EnumType.STRING)
    private Role role;


    public User(Long id, String name, String surname, String username, String password,Role role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User() {
    }
}
