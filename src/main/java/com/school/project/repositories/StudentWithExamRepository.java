package com.school.project.repositories;

import com.school.project.classes.Student;
import com.school.project.classes.StudentWithExam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentWithExamRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<StudentWithExam> findAll() {

        String sql = "SELECT Student.*, Exam.examName, Exam.examDate, Exam.examGrade FROM Student\n" +
                "INNER JOIN Exam\n" +
                "ON Exam.examId = Student.studentId;";

        return jdbcTemplate.query(
                sql,
                (reponse, rownumber) ->
                        new StudentWithExam(reponse.getInt("studentid"),
                                reponse.getString("firstName"),
                                reponse.getString("lastname"),
                                reponse.getString("gender"),
                                reponse.getString("group"),
                                reponse.getDouble("average"),
                                reponse.getString("examName"),
                                reponse.getDate("examDate"),
                                reponse.getInt("examGrade")));
    }

    public List<StudentWithExam> findByGenderAndGrade(String gender, int examGrade) {
        String sql = "SELECT Student.*, Exam.examName, Exam.examDate, Exam.examGrade FROM Student\n" +
                "INNER JOIN Exam\n" +
                "ON Exam.examId = Student.studentId\n" +
                "WHERE gender = ? AND examGrade = ?;";

        Object[] inputs = new Object[] {gender, examGrade};

        return  jdbcTemplate.query(
                sql,
                inputs,
                (reponse, rownumber) ->new StudentWithExam (reponse.getInt("studentid"),
                        reponse.getString("firstName"),
                        reponse.getString("lastname"),
                        reponse.getString("gender"),
                        reponse.getString("group"),
                        reponse.getDouble("average"),
                        reponse.getString("examName"),
                        reponse.getDate("examDate"),
                        reponse.getInt("examGrade")));
    }

}
