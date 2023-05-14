package mk.ukim.finki.codecamp.service;

import mk.ukim.finki.codecamp.model.Answer;

import java.util.List;

public interface AnswerService {

    Answer findById(Long id);

    Answer findCorrectAnswerByQuestionId(Long questionId);

    List<Answer> findAll();

    List<Answer> findAllProvidedAnswersByQuestionId(Long questionId);

    Answer create(String answer);

    Answer edit(Long questionId, String answer);

    void delete(Long id);
}
