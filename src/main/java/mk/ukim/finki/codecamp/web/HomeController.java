package mk.ukim.finki.codecamp.web;

import mk.ukim.finki.codecamp.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/", "/home"})
public class HomeController {


    @GetMapping
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
