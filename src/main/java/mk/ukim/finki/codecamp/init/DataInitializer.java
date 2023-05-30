package mk.ukim.finki.codecamp.init;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import mk.ukim.finki.codecamp.model.Course;
import mk.ukim.finki.codecamp.model.Lecture;
import mk.ukim.finki.codecamp.model.Role;
import mk.ukim.finki.codecamp.repository.UserRepository;
import mk.ukim.finki.codecamp.service.AuthService;
import mk.ukim.finki.codecamp.service.CourseService;
import mk.ukim.finki.codecamp.service.LectureService;
import mk.ukim.finki.codecamp.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final CourseService courseService;
    private final LectureService lectureService;
    private final UserService userService;



    @PostConstruct
    public void init() {
        Course ictCourse = courseService.createEmpty("Summer", "ICT Projects", "https://galooli.com/wp-content/uploads/2022/06/glossary_1122x777_What-is-ICT.png");
        Course knCourse = courseService.createEmpty("Summer", "Kognitivni Nauki", "https://cdn-wordpress-info.futurelearn.com/wp-content/uploads/93e85169-4f3c-4b4b-8f8f-45956f4e2eb7-3.jpg.optimal.jpg");
        Course dbCourse = courseService.createEmpty("Winter", "Databases", "https://www.aceinfoway.com/blog/wp-content/uploads/2020/03/Best-Database-to-work-with-in-2020.jpg");
        Course webCourse = courseService.createEmpty("Winter", "Web Programming", "https://f.hubspotusercontent10.net/hubfs/6448316/web-programming-languages.jpg");

        String ytEmbedBase = "https://youtube.com/embed/";

        Lecture webLecture1 = lectureService.create("Introduction to Web Development", ytEmbedBase + "EceJQ05KTf4", "Welcome to the Introduction of Full Stack Web Development Tutorial Course 2022, with this course you will learn how to be a Full Stack Web Developer from scratch.");
        Lecture webLecture2 = lectureService.create("What is an IDE?", ytEmbedBase + "qFQN7ytQ-fM", "Welcome to the second tutorial of the #FullStackWebDevelopment Tutorial Course 2022. In this video, we will be learning about which IDE is best for web development, how to install Brackets IDE, which is an open-source text editor that understands web design and How to use brackets to make a website.");
        Lecture webLecture3 = lectureService.create("Building Your First Website", ytEmbedBase + "AHNlZ-35ezM", "Welcome to the third tutorial of the #FullStackWebDevelopment Tutorial Course, in this video you will be Building Your First Website by Learning HTML. You will be learning about the basics of HTML tags and how to write #HTML code.");
        Lecture webLecture4 = lectureService.create("Intro to HTML, HEAD, BODY, and HEADER ", ytEmbedBase + "GN9pTFwY7HM", "Welcome to the fourth tutorial of the #FullStackWebDevelopment Tutorial Course, in this video you will be learning about the basic structure and elements of HTML. The website is a very beginner level #website using #HTML only which shows the use of some basic HTML tags and how to use it inside the code. You will be learning about some major #HTMLTags - html, head, head, body, header, footer.");
        courseService.addLectureToCourse(webCourse.getId(), webLecture1);
        courseService.addLectureToCourse(webCourse.getId(), webLecture2);
        courseService.addLectureToCourse(webCourse.getId(), webLecture3);
        courseService.addLectureToCourse(webCourse.getId(), webLecture4);


        Lecture ictLecture1 = lectureService.create("What does the course cover?", ytEmbedBase + "hsMNZd3ssqM", "Beginner to Project Manager hi my name is ivan and i'm going to be taking you through the project management course i have gained my professional experience while working in the fields of international management consulting and insurance most notably i have spent the past several years as a project manager for the american international group aig also i am a certified project management professional and will be happy to share my expertise.");
        Lecture ictLecture2 = lectureService.create("What is a Project?", ytEmbedBase + "What is a Project", "Beginner to Project Manager hi my name is ivan and i'm going to be taking you through the project management course i have gained my professional experience while working in the fields of international management consulting and insurance most notably i have spent.");
        Lecture ictLecture3 = lectureService.create("Why do companies execute projects?", ytEmbedBase + "SfO9TesOacs", "Beginner to Project Manager hi my name is ivan and i'm going to be taking you through the project management course i have gained my professional experience while working in the fields of international management consulting and insurance most notably i have spent.");
        Lecture ictLecture4 = lectureService.create("Project management terminology", ytEmbedBase + "Y_ugprSfENM", "Beginner to Project Manager hi my name is ivan and i'm going to be taking you through the project management course i have gained my professional experience while working in the fields of international management consulting and insurance most notably i have spent.");
        courseService.addLectureToCourse(ictCourse.getId(), ictLecture1);
        courseService.addLectureToCourse(ictCourse.getId(), ictLecture2);
        courseService.addLectureToCourse(ictCourse.getId(), ictLecture3);
        courseService.addLectureToCourse(ictCourse.getId(), ictLecture4);


        Lecture knLecture1 = lectureService.create("History of Cognitive Science", ytEmbedBase + "uuDRmW1gB7I", "COMP 47230 is an Introduction to Cognitive Science taught to graduate students at University College Dublin. The lecturer is Fred Cummins.");
        Lecture knLecture2 = lectureService.create("Language and Languaging", ytEmbedBase + "FKA-9tKJD6Q", "COMP 47230 is an Introduction to Cognitive Science taught to graduate students at University College Dublin. The lecturer is Fred Cummins.");
        Lecture knLecture3 = lectureService.create("Perception", ytEmbedBase + "34VQHoELrX4", "COMP 47230 is an Introduction to Cognitive Science taught to graduate students at University College Dublin. The lecturer is Fred Cummins.");
        Lecture knLecture4 = lectureService.create("Movement", ytEmbedBase + "flaT5dapWUM", "COMP 47230 is an Introduction to Cognitive Science taught to graduate students at University College Dublin. The lecturer is Fred Cummins.");
        courseService.addLectureToCourse(knCourse.getId(), knLecture1);
        courseService.addLectureToCourse(knCourse.getId(), knLecture2);
        courseService.addLectureToCourse(knCourse.getId(), knLecture3);
        courseService.addLectureToCourse(knCourse.getId(), knLecture4);


        Lecture dbLecture1 = lectureService.create("Introduction to Databases", ytEmbedBase + "B8ij7Fin6qk", "This is the first introductory lecture of our databases course with an overview of important concepts in relational databases: database management systems (DBMS), the ANSI-SPARC architecture, physical and logical data independence, the relational model, database schemas and instances, the structured query language (SQL).");
        Lecture dbLecture2 = lectureService.create("Relational Model", ytEmbedBase + "pEPDhM4rKXs", "This is the first introductory lecture of our databases course with an overview of important concepts in relational databases: database management systems (DBMS), the ANSI-SPARC architecture, physical and logical data independence, the relational model, database schemas and instances, the structured query language (SQL).");
        Lecture dbLecture3 = lectureService.create("Integrity Constraints", ytEmbedBase + "Ph5CohiRP1U", "This is the first introductory lecture of our databases course with an overview of important concepts in relational databases: database management systems (DBMS), the ANSI-SPARC architecture, physical and logical data independence, the relational model, database schemas and instances, the structured query language (SQL).");
        Lecture dbLecture4 = lectureService.create("Foreign Keys", ytEmbedBase + "1YhVeh5YLl4", "This is the first introductory lecture of our databases course with an overview of important concepts in relational databases: database management systems (DBMS), the ANSI-SPARC architecture, physical and logical data independence, the relational model, database schemas and instances, the structured query language (SQL).");
        courseService.addLectureToCourse(dbCourse.getId(), dbLecture1);
        courseService.addLectureToCourse(dbCourse.getId(), dbLecture2);
        courseService.addLectureToCourse(dbCourse.getId(), dbLecture3);
        courseService.addLectureToCourse(dbCourse.getId(), dbLecture4);



        userService.register(1L,"ile123123","Ile123123123%","Ile123123123%","ile","ile", Role.valueOf("ROLE_STUDENT"));
        userService.register(2L,"aa","aa","aa","aa","aa", Role.valueOf("ROLE_ADMIN"));

    }
}
