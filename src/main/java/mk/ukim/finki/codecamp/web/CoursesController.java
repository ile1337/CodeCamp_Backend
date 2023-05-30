package mk.ukim.finki.codecamp.web;

import jakarta.servlet.http.HttpServletRequest;
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
    public String getCoursesPage(@RequestParam(required = false) String error, Model model, HttpServletRequest request) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Course> courses = this.courseService.findAll();
        model.addAttribute("user", request.getSession().getAttribute("user"));
        model.addAttribute("courses", courses);
        model.addAttribute("bodyContent", "courses");
        return "master-template";
    }


    @GetMapping("/edit-form/{id}")
//    @PreAuthorize("hasAnyRole(ROLE_ADMIN, ROLE_PROFESSOR)")
    public String editCoursePage(@PathVariable Long id, Model model) {
        Course course = this.courseService.findById(id);
        model.addAttribute("course", course);
        model.addAttribute("bodyContent", "add-course");
        return "master-template";
    }

    @GetMapping("/add-form")
//    @PreAuthorize("hasAnyRole(ROLE_ADMIN, ROLE_PROFESSOR)")
    public String addCoursePage(Model model) {
//        List<Course> courses = this.courseService.findAll();
//        List<Lecture> lectures = this.lectureService.findAll();
//        model.addAttribute("courses", courses);
//        model.addAttribute("lectures", lectures);
        model.addAttribute("bodyContent", "add-course");
        return "master-template";
    }

    @PostMapping("/add")
    public String saveProduct(
            @RequestParam(required = false) Long id,
            @RequestParam String semester,
            @RequestParam String title,
            @RequestParam String pictureurl
           ) {

        if (id == null)
            this.courseService.createEmpty(semester, title, pictureurl);
        else
            this.courseService.editEmpty(id, semester, title, pictureurl);

        return "redirect:/courses";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id) {
        this.courseService.delete(id);
        return "redirect:/courses";
    }

    @GetMapping("/{id}/lectures")
    public String getCourseLectures(@PathVariable Long id) {
        return "redirect:/courses/" + id.toString() + "/lecture/1";
    }

    @GetMapping("/{courseId}/lecture/{lectureId}/previous")
    public String getPreviousLecture(@PathVariable Long courseId, @PathVariable int lectureId) {
        return "redirect:/courses/" + courseId.toString() + "/lecture/" + String.format("%d",lectureId - 1);
    }

    @GetMapping("/{courseId}/lecture/{lectureId}/next")
    public String getNextLecture(@PathVariable Long courseId, @PathVariable int lectureId) {
        return "redirect:/courses/" + courseId.toString() + "/lecture/" + String.format("%d",lectureId + 1);
    }

    @GetMapping("/{id}/lecture/{lectureNum}")
    public String getCourseLecture(@PathVariable Long id, @PathVariable int lectureNum, Model model) {
        List<Lecture> lectures = this.lectureService.findLecturesByCourseId(id);
        if (lectureNum <= 1) lectureNum = 1;
        else if (lectureNum >= lectures.size()) lectureNum = lectures.size();

        model.addAttribute("courseId", id);
        model.addAttribute("lecture", lectures.get(lectureNum-1));
        model.addAttribute("lectureNum", lectureNum);
        model.addAttribute("canPrevious", lectureNum > 1);
        model.addAttribute("canNext", lectureNum < lectures.size());
        model.addAttribute("bodyContent", "course-lecture");
        return "master-template";
    }

}
