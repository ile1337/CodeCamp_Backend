package mk.ukim.finki.codecamp.init;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import mk.ukim.finki.codecamp.model.Role;
import mk.ukim.finki.codecamp.repository.UserRepository;
import mk.ukim.finki.codecamp.service.AuthService;
import mk.ukim.finki.codecamp.service.CourseService;
import mk.ukim.finki.codecamp.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final CourseService courseService;
    private final UserService userService;



    @PostConstruct
    public void init() {
        courseService.createEmpty("Summer", "ICT Projects");
        courseService.createEmpty("Summer", "Kognitivni Nauki");
        courseService.createEmpty("Winter", "Databases");
        userService.register(1L,"ile123123","Ile123123123%","Ile123123123%","ile","ile", Role.valueOf("ROLE_STUDENT"));

    }
}
