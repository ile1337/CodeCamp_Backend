package mk.ukim.finki.codecamp.service.impl;

import mk.ukim.finki.codecamp.model.Course;
import mk.ukim.finki.codecamp.model.Lecture;
import mk.ukim.finki.codecamp.model.Quiz;
import mk.ukim.finki.codecamp.model.exceptions.InvalidArgumentException;
import mk.ukim.finki.codecamp.model.exceptions.NoSuchIdException;
import mk.ukim.finki.codecamp.repository.CourseRepository;
import mk.ukim.finki.codecamp.repository.LectureRepository;
import mk.ukim.finki.codecamp.repository.QuizRepository;
import mk.ukim.finki.codecamp.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final LectureRepository lectureRepository;
    private final QuizRepository quizRepository;

    public CourseServiceImpl(CourseRepository courseRepository, LectureRepository lectureRepository, QuizRepository quizRepository) {
        this.courseRepository = courseRepository;
        this.lectureRepository = lectureRepository;
        this.quizRepository = quizRepository;
    }

    @Override
    public Course findById(Long id) {
        return this.courseRepository.findById(id).orElseThrow(() -> new NoSuchIdException(id));
    }

    @Override
    public Course findByTitle(String title) {
        return this.courseRepository.findByTitle(title).orElseThrow(InvalidArgumentException::new);
    }

    @Override
    public List<Course> findAll() {
        return this.courseRepository.findAll();
    }

    @Override
    public List<Course> findAllInSemester(String semester) {
        return this.courseRepository.findAllBySemester(semester);
    }

    @Override
    public Course createEmpty(String semester, String title, String pictureUrl) {
        Course newCourse = new Course(semester, title, pictureUrl);
        return this.courseRepository.save(newCourse);
    }

    @Override
    public Course create(String semester, String title, ArrayList<Long> lectureIds, Long quizId) {
        List<Lecture> lectures = this.lectureRepository.findAllById(lectureIds);
        Quiz quiz = this.quizRepository.findById(quizId).orElseThrow(InvalidArgumentException::new);

        Course newCourse = new Course(semester, title, lectures, quiz);
        return this.courseRepository.save(newCourse);
    }

    @Override
    public Course editEmpty(Long courseId, String semester, String title, String pictureUrl) {
        Course newCourse = this.courseRepository.findById(courseId).orElseThrow(() -> new NoSuchIdException(courseId));
        newCourse.setTitle(title);
        newCourse.setSemester(semester);
        newCourse.setPictureUrl(pictureUrl);
        return this.courseRepository.save(newCourse);
    }

    @Override
    public Course edit(Long courseId, String semester, String title, ArrayList<Long> lectureIds, Long quizId) {
        List<Lecture> lectures = this.lectureRepository.findAllById(lectureIds);
        Quiz quiz = this.quizRepository.findById(quizId).orElseThrow(InvalidArgumentException::new);

        Course newCourse = this.courseRepository.findById(courseId).orElseThrow(() -> new NoSuchIdException(courseId));
        newCourse.setTitle(title);
        newCourse.setSemester(semester);
        newCourse.setLectures(lectures);
        newCourse.setQuiz(quiz);
        return this.courseRepository.save(newCourse);
    }

    @Override
    public void addLectureToCourse(Long courseId, Lecture lecture) {
        Course newCourse = this.courseRepository.findById(courseId).orElseThrow(() -> new NoSuchIdException(courseId));
        newCourse.addLecture(lecture);
        this.courseRepository.save(newCourse);
    }

    @Override
    public boolean isPresent(Long courseId) {
        return this.courseRepository.findById(courseId).equals(courseId);
    }

    @Override
    public void delete(Long id) {
        this.courseRepository.deleteById(id);
    }
}
