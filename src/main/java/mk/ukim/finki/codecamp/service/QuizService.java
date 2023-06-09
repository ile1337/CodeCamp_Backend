package mk.ukim.finki.codecamp.service;

import mk.ukim.finki.codecamp.model.Quiz;

import java.util.ArrayList;
import java.util.List;

public interface QuizService {

    Quiz findById(Long id);

    Quiz findByCourseId(Long courseId);

    List<Quiz> findAll();

    Quiz create(Long completionTime);

    Quiz edit(Long quizId, Long completionTime);

    void delete(Long id);
}
