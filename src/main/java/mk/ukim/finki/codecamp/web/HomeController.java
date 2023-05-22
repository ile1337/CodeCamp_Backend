package mk.ukim.finki.codecamp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String getHome(Model model) {
        model.addAttribute("bodyContent", "home");
        return "master-template";
    }
    @GetMapping("/courses")
    public String getCourses(Model model) {
        model.addAttribute("bodyContent", "courses");
        return "master-template";
    }
    @GetMapping("/about-us")
    public String getAboutUs(Model model) {
        model.addAttribute("bodyContent", "about-us");
        return "master-template";
    }
}
