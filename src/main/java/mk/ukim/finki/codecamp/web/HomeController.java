package mk.ukim.finki.codecamp.web;

import mk.ukim.finki.codecamp.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/home")
    public String getHome(Model model) {
        model.addAttribute("bodyContent", "home");
        return "master-template";
    }

    @GetMapping("/about-us")
    public String getAboutUs(Model model) {
        model.addAttribute("bodyContent", "about-us");
        return "master-template";
    }
}
