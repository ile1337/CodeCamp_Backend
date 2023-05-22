package mk.ukim.finki.codecamp.repository;

import mk.ukim.finki.codecamp.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    Optional<Course> findByTitle(String title);
    List<Course> findAllBySemester(String semester);
}
