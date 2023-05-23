package mk.ukim.finki.codecamp.web;

import mk.ukim.finki.codecamp.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CourseService courseService;

    public HomeController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/home")
    public String getHome(Model model) {
        model.addAttribute("bodyContent", "home");
        return "master-template";
    }
    @GetMapping("/courses")
    public String getCourses(Model model) {
        model.addAttribute("bodyContent", "courses");
        model.addAttribute("courses", this.courseService.findAll());
        return "master-template";
    }
    @GetMapping("/about-us")
    public String getAboutUs(Model model) {
        model.addAttribute("bodyContent", "about-us");
        return "master-template";
    }
}
