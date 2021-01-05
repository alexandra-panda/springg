package com.school.project.controllers;

import com.school.project.classes.Exam;
import com.school.project.repositories.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("school")
public class ExamController {
    @Autowired
    ExamRepository examRepository;

    @GetMapping("exam")
    public List<Exam> findAll() {
        return examRepository.findAll();
    }

    @GetMapping("exam/{examId}")
    public  Exam findById(@PathVariable int examId){
        return examRepository.findById(examId);
    }

    @PostMapping("exam")
    public void save(@RequestBody Exam exam) {
        examRepository.save(exam);
    }

    @PutMapping("exam/{examName}")
    public void update(@RequestBody Exam exam, @PathVariable String examName) {
        examRepository.update(exam,examName);
    }

    @DeleteMapping("exam/{examName}")
    public void delete(@PathVariable String examName) {
        examRepository.delete(examName);
    }
}
