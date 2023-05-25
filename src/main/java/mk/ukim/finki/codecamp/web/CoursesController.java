package mk.ukim.finki.codecamp.web;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.codecamp.model.Course;
import mk.ukim.finki.codecamp.model.Lecture;
import mk.ukim.finki.codecamp.model.Quiz;
import mk.ukim.finki.codecamp.model.User;
import mk.ukim.finki.codecamp.service.CourseService;
import mk.ukim.finki.codecamp.service.LectureService;

import java.util.ArrayList;
import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CoursesController {

    private final CourseService courseService;
    private final LectureService lectureService;

    @GetMapping
    public String getCoursesPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Course> courses = this.courseService.findAll();
        model.addAttribute("courses", courses);
        model.addAttribute("bodyContent", "courses");
        return "master-template";
    }


    @GetMapping("/edit-form/{id}")
    @PreAuthorize("hasAnyRole(ROLE_ADMIN, ROLE_PROFESSOR)")
    public String editCoursePage(@PathVariable Long id, Model model) {
        if (this.courseService.findById(id).equals(id)) {
            Course course = this.courseService.findById(id);
            List<Lecture> lectures = this.lectureService.findAll();
            model.addAttribute("lectures", lectures);
            model.addAttribute("course", course);
            model.addAttribute("bodyContent", "add-course");
            return "master-template";
        }
        return "redirect:/courses?error=CourseNotFound";
    }

    @GetMapping("/add-form")
    @PreAuthorize("hasAnyRole(ROLE_ADMIN, ROLE_PROFESSOR)")
    public String addCoursePage(Model model) {
        List<Course> courses = this.courseService.findAll();
        List<Lecture> lectures = this.lectureService.findAll();
        model.addAttribute("courses", courses);
        model.addAttribute("lectures", lectures);
        model.addAttribute("bodyContent", "add-course");
        return "master-template";
    }

    @PostMapping("/add")
    public String saveProduct(
            @RequestParam String semester,
            @RequestParam String title,
            @RequestParam ArrayList<Long> lectureIds,
            @RequestParam Long quizId
           ) {

            this.courseService.create( semester, title, lectureIds, quizId);

        return "redirect:/courses";
    }

}
