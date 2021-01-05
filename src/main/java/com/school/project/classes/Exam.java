package com.school.project.classes;

import java.util.Date;

public class Exam {
    private int examId;
    private String examName;
    private Date examDate;
    private int examGrade;

    public Exam(int examId, String examName, Date examDate, int examGrade) {
        this.examId = examId;
        this.examName = examName;
        this.examDate = examDate;
        this.examGrade = examGrade;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
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
