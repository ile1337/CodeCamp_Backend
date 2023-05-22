package mk.ukim.finki.codecamp.repository;

import mk.ukim.finki.codecamp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
