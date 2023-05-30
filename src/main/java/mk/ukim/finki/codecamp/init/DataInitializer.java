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
        courseService.createEmpty("Summer", "ICT Projects", "https://galooli.com/wp-content/uploads/2022/06/glossary_1122x777_What-is-ICT.png");
        courseService.createEmpty("Summer", "Kognitivni Nauki", "https://cdn-wordpress-info.futurelearn.com/wp-content/uploads/93e85169-4f3c-4b4b-8f8f-45956f4e2eb7-3.jpg.optimal.jpg");
        courseService.createEmpty("Winter", "Databases", "https://www.aceinfoway.com/blog/wp-content/uploads/2020/03/Best-Database-to-work-with-in-2020.jpg");
        courseService.createEmpty("Winter", "Web Programming", "https://f.hubspotusercontent10.net/hubfs/6448316/web-programming-languages.jpg");
        userService.register(1L,"ile123123","Ile123123123%","Ile123123123%","ile","ile", Role.valueOf("ROLE_STUDENT"));

    }
}
