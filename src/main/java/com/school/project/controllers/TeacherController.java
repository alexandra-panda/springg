package com.school.project.controllers;

import com.school.project.classes.Teacher;
import com.school.project.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("school")
public class TeacherController {
    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping("teacher")
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @GetMapping("teacher/{teacherId}")
    public  Teacher findById(@PathVariable int teacherId){
        return teacherRepository.findById(teacherId);
    }

    @PostMapping("teacher")
    public void save(@RequestBody Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @PutMapping("teacher/{firstName}")
    public void update(@RequestBody Teacher teacher, @PathVariable String firstName) {
        teacherRepository.update(teacher,firstName);
    }

    @DeleteMapping("teacher/{firstName}")
    public void delete(@PathVariable String firstName) {
        teacherRepository.delete(firstName);
    }
}

