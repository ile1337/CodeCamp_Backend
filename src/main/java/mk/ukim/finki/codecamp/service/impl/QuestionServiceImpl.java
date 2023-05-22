package mk.ukim.finki.codecamp.service.impl;

import mk.ukim.finki.codecamp.model.Question;
import mk.ukim.finki.codecamp.model.Quiz;
import mk.ukim.finki.codecamp.model.exceptions.NoSuchIdException;
import mk.ukim.finki.codecamp.repository.QuestionRepository;
import mk.ukim.finki.codecamp.repository.QuizRepository;
import mk.ukim.finki.codecamp.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final QuizRepository quizRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository, QuizRepository quizRepository) {
        this.questionRepository = questionRepository;
        this.quizRepository = quizRepository;
    }

    @Override
    public Question findById(Long id) {
        return this.questionRepository.findById(id).orElseThrow(() -> new NoSuchIdException(id));
    }

    @Override
    public List<Question> findAll() {
        return this.questionRepository.findAll();
    }

    @Override
    public List<Question> findAllByQuizId(Long quizId) {
        Quiz quiz = this.quizRepository.findById(quizId).orElseThrow(() -> new NoSuchIdException(quizId));
        return quiz.getQuestions();
    }

    @Override
    public Question create(String question, Long points) {
        Question newQuestion = new Question(question, points);
        return this.questionRepository.save(newQuestion);
    }

    @Override
    public Question edit(Long questionId, String question, Long points) {
        Question newQuestion = this.questionRepository.findById(questionId).orElseThrow(() -> new NoSuchIdException(questionId));
        newQuestion.setQuestion(question);
        newQuestion.setPoints(points);
        return this.questionRepository.save(newQuestion);
    }

    @Override
    public void delete(Long id) {
        this.questionRepository.deleteById(id);
    }
}
