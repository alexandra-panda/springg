package com.school.project.controllers;

import com.school.project.classes.Student;
import com.school.project.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @GetMapping("student")
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @GetMapping("student/{studentId}")
    public  Student findById(@PathVariable int studentId){
        return studentRepository.findById(studentId);
    }

    @PostMapping("student")
    public void save(@RequestBody Student student) {
        studentRepository.save(student);
    }

    @PutMapping("student/{firstName}")
    public void update(@RequestBody Student student, @PathVariable String firstName) {
        studentRepository.update(student,firstName);
    }

    @DeleteMapping("student/{firstName}")
    public void delete(@PathVariable String firstName) {
        studentRepository.delete(firstName);
    }
}
