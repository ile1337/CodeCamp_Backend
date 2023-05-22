package mk.ukim.finki.codecamp.service.impl;

import mk.ukim.finki.codecamp.model.Lecture;
import mk.ukim.finki.codecamp.model.exceptions.NoSuchIdException;
import mk.ukim.finki.codecamp.repository.CourseRepository;
import mk.ukim.finki.codecamp.repository.LectureRepository;
import mk.ukim.finki.codecamp.service.LectureService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectureServiceImpl implements LectureService {

    private final LectureRepository lectureRepository;
    private final CourseRepository courseRepository;

    public LectureServiceImpl(LectureRepository lectureRepository, CourseRepository courseRepository) {
        this.lectureRepository = lectureRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public Lecture findById(Long id) {
        return this.lectureRepository.findById(id).orElseThrow(() -> new NoSuchIdException(id));
    }

    @Override
    public List<Lecture> findAll() {
        return this.lectureRepository.findAll();
    }

    @Override
    public List<Lecture> findLecturesByCourseId(Long courseId) {
        return this.courseRepository.findById(courseId).orElseThrow(() -> new NoSuchIdException(courseId)).getLectures();
    }

    @Override
    public Lecture create(String title, String videoUrl, String desc) {
        Lecture newLecture = new Lecture(title, videoUrl, desc);
        return this.lectureRepository.save(newLecture);
    }

    @Override
    public Lecture edit(Long id, String title, String videoUrl, String desc) {
        Lecture newLecture = this.lectureRepository.findById(id).orElseThrow(() -> new NoSuchIdException(id));
        newLecture.setTitle(title);
        newLecture.setVideoUrl(videoUrl);
        newLecture.setDescription(desc);
        return this.lectureRepository.save(newLecture);
    }

    @Override
    public void delete(Long id) {
        this.lectureRepository.deleteById(id);
    }
}
