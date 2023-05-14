package mk.ukim.finki.codecamp.service;

import mk.ukim.finki.codecamp.model.User;

import java.util.List;

public interface UserService {

    User findById(Long id);

    List<User> findAll();

    User register(String name, String surname, String password);

    User editAccount(Long userId, String name, String surname, String password);

    void deleteAccount(Long id);
}
