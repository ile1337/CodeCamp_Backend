package mk.ukim.finki.codecamp.repository;

import mk.ukim.finki.codecamp.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer,Long> {
}
