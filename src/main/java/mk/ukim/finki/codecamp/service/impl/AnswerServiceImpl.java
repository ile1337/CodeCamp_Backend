package mk.ukim.finki.codecamp.service.impl;

import mk.ukim.finki.codecamp.model.Answer;
import mk.ukim.finki.codecamp.model.Question;
import mk.ukim.finki.codecamp.model.exceptions.NoSuchIdException;
import mk.ukim.finki.codecamp.repository.AnswerRepository;
import mk.ukim.finki.codecamp.repository.QuestionRepository;
import mk.ukim.finki.codecamp.service.AnswerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    public AnswerServiceImpl(AnswerRepository answerRepository, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public Answer findById(Long id) {
        return answerRepository.findById(id).orElseThrow(() -> new NoSuchIdException(id));
    }

    @Override
    public Answer findCorrectAnswerByQuestionId(Long questionId) {
        Question question = this.questionRepository.findById(questionId).orElseThrow(() -> new NoSuchIdException(questionId));
        return question.getCorrectAnswer();
    }

    @Override
    public List<Answer> findAll() {
        return this.answerRepository.findAll();
    }

    @Override
    public List<Answer> findAllProvidedAnswersByQuestionId(Long questionId) {
        Question question = this.questionRepository.findById(questionId).orElseThrow(() -> new NoSuchIdException(questionId));
        return question.getProvidedAnswers();
    }

    @Override
    public Answer create(String answer) {
        Answer newAnswer = new Answer(answer);
        return this.answerRepository.save(newAnswer);
    }

    @Override
    public Answer edit(Long answerId, String answer) {
        Answer updateAnswer = this.answerRepository.findById(answerId).orElseThrow(() -> new NoSuchIdException(answerId));
        updateAnswer.setAnswer(answer);
        return this.answerRepository.save(updateAnswer);
    }

    @Override
    public void delete(Long id) {
        this.answerRepository.deleteById(id);
    }
}
