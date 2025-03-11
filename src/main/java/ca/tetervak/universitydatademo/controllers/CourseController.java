package ca.tetervak.universitydatademo.controllers;

import ca.tetervak.universitydatademo.domain.Course;
import ca.tetervak.universitydatademo.repository.CourseRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {
    private CourseRepository courseRepository;
    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    @GetMapping("/courses")
    public Iterable<Course> getAllCourses() {
        return courseRepository.findAll();
    }
    @PutMapping(value = "/course", consumes = "application/json")
    public String addCourse(@RequestBody Course course) {
        courseRepository.save(course);
        return "Course" + course + "added";
    }
    @PutMapping(value = "/courses", consumes = "application/json")
    public String addCourses(@RequestBody List<Course> courses) {
        courseRepository.saveAll(courses);
        return "Number of courses added: " + courses.size();
    }
}
