package com.example.student.Service;
import com.example.student.Entity.Student;
import com.example.student.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repo;

    // GET all students
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    // CREATE student
    public Student createStudent(Student s) {
        return repo.save(s);
    }

    // DELETE student
    public String deleteStudent(int id) {
        repo.deleteById(id);
        return "Student deleted successfully";
    }

    // UPDATE student
    public Student updateStudent(Student s, int id) {
        Student existing = repo.findById(id).orElse(null);

        if (existing != null) {
            existing.setFirstname(s.getFirstname());
            existing.setLastname(s.getLastname());
            existing.setResult(s.getResult());

            return repo.save(existing);  // ✅ correct object
        } else {
            return null;
        }
    }
}
