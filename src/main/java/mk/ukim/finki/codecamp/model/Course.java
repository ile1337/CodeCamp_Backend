package mk.ukim.finki.codecamp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Data
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String semester;

    private String title;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Lecture> lectures;

    @OneToOne
    private Quiz quiz;

    @ManyToMany
    private List<User> students;

    @ManyToOne
    private User administrator;

    @OneToOne
    private User teacher;

    public Course(String semester, String title) {
        this.semester = semester;
        this.title = title;
        this.lectures = new ArrayList<>();
        this.quiz = null;
        this.students = new ArrayList<>();
        this.administrator = null;
        this.teacher = null;
    }

    public Course(String semester, String title, List<Lecture> lectures, Quiz quiz) {
        this.semester = semester;
        this.title = title;
        this.lectures = lectures;
        this.quiz = quiz;
        this.students = new ArrayList<>();
        this.administrator = null;
        this.teacher = null;
    }

    public Course(String semester, String title, List<Lecture> lectures, Quiz quiz, List<User> students, User administrator, User teacher) {
        this.semester = semester;
        this.title = title;
        this.lectures = lectures;
        this.quiz = quiz;
        this.students = students;
        this.administrator = administrator;
        this.teacher = teacher;
    }

    public Course() {
    }
}
