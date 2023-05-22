package mk.ukim.finki.codecamp.service;

import mk.ukim.finki.codecamp.model.Question;

import java.util.List;

public interface QuestionService {

    Question findById(Long id);

    List<Question> findAll();

    List<Question> findAllByQuizId(Long quizId);

    Question create(String question, Long points);

    Question edit(Long questionId, String question, Long points);

    void delete(Long id);
}
