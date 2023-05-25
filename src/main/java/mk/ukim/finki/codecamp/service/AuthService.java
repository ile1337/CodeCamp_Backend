package mk.ukim.finki.codecamp.service;

import mk.ukim.finki.codecamp.model.User;

public interface AuthService {
    User login(String username, String password);
}
