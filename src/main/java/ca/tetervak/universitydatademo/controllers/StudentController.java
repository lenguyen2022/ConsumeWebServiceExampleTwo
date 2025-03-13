package ca.tetervak.universitydatademo.controllers;

import ca.tetervak.universitydatademo.domain.Hello;
import ca.tetervak.universitydatademo.domain.Student;
import ca.tetervak.universitydatademo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class StudentController {
    private StudentRepository studentRepository;
    @Autowired
    private String funBean;
    @Autowired
    private Hello hello;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/students")
    public Iterable<Student> getStudent(){
        Logger logger = Logger.getLogger(funBean);
        logger.info(funBean);
        hello.setName("Hello From StudentController");
        logger.info("Message = " + hello.getName());
        return this.studentRepository.findAll();
    }
    @PutMapping(value = "/student", consumes = "application/json")
    public String addStudent(@RequestBody Student student) {
        studentRepository.save(student);

        return student.toString();
    }
    @PutMapping(value = "/students", consumes = "application/json")
    public String addStudents(@RequestBody List<Student> students) {
        studentRepository.saveAll(students);
        return "Number of students added: " + students.size();
    }
}
