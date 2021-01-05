package com.school.project.classes;

import java.util.Date;

public class StudentWithExam extends Student {
    private String examName;
    private Date examDate;
    private int examGrade;

    public StudentWithExam(int studentId, String firstName, String lastName, String gender, String group, double average, String examName, Date examDate, int examGrade) {
        super(studentId, firstName, lastName, gender, group, average);
        this.examName = examName;
        this.examDate = examDate;
        this.examGrade = examGrade;
    }

    public StudentWithExam(int studentId, String firstName, String lastName, String gender, String group, double average, String examName) {
        super(studentId, firstName, lastName, gender, group, average);
        this.examName = examName;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public int getExamGrade() {
        return examGrade;
    }

    public void setExamGrade(int examGrade) {
        this.examGrade = examGrade;
    }
}
