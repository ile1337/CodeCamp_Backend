package mk.ukim.finki.codecamp.init;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.codecamp.service.CourseService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DataInitializer {

    private final CourseService courseService;

    public DataInitializer(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostConstruct
    public void init() {
        courseService.createEmpty("Summer", "ICT Projects");
        courseService.createEmpty("Summer", "Kognitivni Nauki");
        courseService.createEmpty("Winter", "Databases");
    }
}
