package mk.ukim.finki.codecamp.service;

import mk.ukim.finki.codecamp.model.Course;

import java.util.ArrayList;
import java.util.List;

public interface CourseService {

    Course findById(Long id);

    Course findByTitle(String title);

    List<Course> findAll();

    List<Course> findAllInSemester(String semester);

    Course createEmpty(String semester, String title);

    Course create(String semester, String title, ArrayList<Long> lectureIds, Long quizId);

    Course edit(Long courseId, String semester, String title, ArrayList<Long> lectureIds, Long quizId);

    void delete(Long id);

}
