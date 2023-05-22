package mk.ukim.finki.codecamp.service.impl;

import mk.ukim.finki.codecamp.model.Quiz;
import mk.ukim.finki.codecamp.model.exceptions.NoSuchIdException;
import mk.ukim.finki.codecamp.repository.CourseRepository;
import mk.ukim.finki.codecamp.repository.QuizRepository;
import mk.ukim.finki.codecamp.service.QuizService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;
    private final CourseRepository courseRepository;

    public QuizServiceImpl(QuizRepository quizRepository, CourseRepository courseRepository) {
        this.quizRepository = quizRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public Quiz findById(Long id) {
        return this.quizRepository.findById(id).orElseThrow(() -> new NoSuchIdException(id));
    }

    @Override
    public Quiz findByCourseId(Long courseId) {
        return this.courseRepository.findById(courseId).orElseThrow(() -> new NoSuchIdException(courseId)).getQuiz();
    }

    @Override
    public List<Quiz> findAll() {
        return this.quizRepository.findAll();
    }

    @Override
    public Quiz create(Long completionTime) {
        Quiz newQuiz = new Quiz(completionTime);
        return this.quizRepository.save(newQuiz);
    }

    @Override
    public Quiz edit(Long quizId, Long completionTime) {
        Quiz newQuiz = this.quizRepository.findById(quizId).orElseThrow(() -> new NoSuchIdException(quizId));
        newQuiz.setCompletionTime(completionTime);
        return this.quizRepository.save(newQuiz);
    }

    @Override
    public void delete(Long id) {
        this.quizRepository.deleteById(id);
    }
}
