package ca.tetervak.universitydatademo.controllers;

import ca.tetervak.universitydatademo.domain.Student;
import ca.tetervak.universitydatademo.repository.StudentRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    private StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public String addStudent(Student student) {
        studentRepository.save(student);
        return student.toString();
    }
}
