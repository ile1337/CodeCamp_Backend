package mk.ukim.finki.codecamp.service;

import mk.ukim.finki.codecamp.model.Role;
import mk.ukim.finki.codecamp.model.User;

import java.util.List;

public interface UserService {

    User findById(Long id);

    List<User> findAll();

    User findByUsername(String username);

    User register(Long id,String username, String password, String repeatPassword, String name, String surname, Role userRole);

    User editAccount(Long userId, String name, String surname);

    void deleteAccount(Long id);

}
