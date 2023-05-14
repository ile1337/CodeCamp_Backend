package mk.ukim.finki.codecamp.service;

import mk.ukim.finki.codecamp.model.Lecture;

import java.util.List;

public interface LectureService {

    Lecture findById(Long id);

    List<Lecture> findAll();

    List<Lecture> findLecturesByCourseId(Long courseId);
}
