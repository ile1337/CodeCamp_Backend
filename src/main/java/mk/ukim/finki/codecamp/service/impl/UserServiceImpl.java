package mk.ukim.finki.codecamp.service.impl;

import mk.ukim.finki.codecamp.model.User;
import mk.ukim.finki.codecamp.model.exceptions.NoSuchIdException;
import mk.ukim.finki.codecamp.repository.UserRepository;
import mk.ukim.finki.codecamp.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return this.userRepository.findById(id).orElseThrow(() -> new NoSuchIdException(id));
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User register(String name, String surname) {
        User newUser = new User(name, surname);
        return this.userRepository.save(newUser);
    }

    @Override
    public User editAccount(Long userId, String name, String surname) {
        User newUser = this.userRepository.findById(userId).orElseThrow(() -> new NoSuchIdException(userId));
        newUser.setName(name);
        newUser.setSurname(surname);
        return this.userRepository.save(newUser);
    }

    @Override
    public void deleteAccount(Long id) {
        this.userRepository.deleteById(id);
    }
}
