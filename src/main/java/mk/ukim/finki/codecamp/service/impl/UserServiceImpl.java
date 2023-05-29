package mk.ukim.finki.codecamp.service.impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.codecamp.model.Role;
import mk.ukim.finki.codecamp.model.User;
import mk.ukim.finki.codecamp.model.exceptions.*;
import mk.ukim.finki.codecamp.repository.UserRepository;
import mk.ukim.finki.codecamp.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;



    @Override
    public User findById(Long id) {
        return this.userRepository.findById(id).orElseThrow(() -> new NoSuchIdException(id));
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    /*@Override
    public User register(String name, String surname) {
        User newUser = new User(name, surname);
        return this.userRepository.save(newUser);
    }*/

    @Override
    public User findByUsername(String username){
        return  userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException(username));
    }


    @Override
    public User register(Long id,String username, String password, String repeatPassword, String name, String surname, Role userRole) {
        if (username==null || username.isEmpty()  || password==null || password.isEmpty())
            throw new InvalidUsernameOrPasswordException();
        if (!password.equals(repeatPassword))
            throw new PasswordsDoNotMatchException();
        if(this.userRepository.findByUsername(username).isPresent())
            throw new UsernameAlreadyExistsException(username);
        //User(Long id, String name, String surname, String username, String password)
        User user = new User(id,name,surname,username,password,userRole);
        return userRepository.save(user);
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
