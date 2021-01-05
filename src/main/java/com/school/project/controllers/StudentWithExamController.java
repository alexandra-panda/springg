package com.school.project.controllers;

import com.school.project.classes.StudentWithExam;
import com.school.project.repositories.StudentWithExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/school")
public class StudentWithExamController {
    @Autowired
    StudentWithExamRepository studentWithExamRepository;

    @GetMapping("studentWithExam")
    public List<StudentWithExam> findAll() {
        return studentWithExamRepository.findAll();
    }

    @GetMapping("studentGrade")
    public List<StudentWithExam>  findByGenderAndGrade(@RequestParam String gender, @RequestParam int examGrade){
        return studentWithExamRepository.findByGenderAndGrade(gender,examGrade);
    }

}
