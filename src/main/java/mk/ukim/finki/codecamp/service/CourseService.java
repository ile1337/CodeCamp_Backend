package mk.ukim.finki.codecamp.service;

import mk.ukim.finki.codecamp.model.Course;

import java.util.ArrayList;
import java.util.List;

public interface CourseService {

    Course findById(Long id);

    Course findByTitle(String title);

    List<Course> findAll();

    List<Course> findAllInSemester(String semester);

    Course createEmpty(String semester, String title, String pictureUrl);

    Course create(String semester, String title, ArrayList<Long> lectureIds, Long quizId);

    Course editEmpty(Long courseId, String semester, String title, String pictureUrl);

    Course edit(Long courseId, String semester, String title, ArrayList<Long> lectureIds, Long quizId);

    boolean isPresent(Long courseId);

    void delete(Long id);

}
