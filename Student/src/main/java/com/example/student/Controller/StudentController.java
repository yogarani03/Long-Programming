package com.example.student.Controller;
import com.example.student.Entity.Student;
import com.example.student.Service.StudentService;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping
    public List<Student> getStudents() {
        return service.getAllStudents();
    }

    @PostMapping
    public Student create(@RequestBody Student s) {

        return service.createStudent(s);
    }

    @PutMapping("/{id}")
    public Student update(@RequestBody Student s,@PathVariable int id) {
        return service.updateStudent(s,id);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        return service.deleteStudent(id);
    }
}
