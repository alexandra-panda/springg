package com.school.project.repositories;

import com.school.project.classes.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExamRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Exam> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM Exam",
                (reponse, rownumber) ->
                        new Exam(reponse.getInt("examId"),
                                reponse.getString("examName"),
                                reponse.getDate("examDate"),
                                reponse.getInt("examGrade")));
    }

    public Exam findById(int examId) {
        String sql = "SELECT *FROM Exam WHERE examId = ?;";
        Object[] inputs = new Object[] {examId};

        return jdbcTemplate.queryForObject(
                sql,
                inputs,
                (reponse, rownumber) ->new Exam (reponse.getInt("examId"),
                        reponse.getString("examName"),
                        reponse.getDate("examDate"),
                        reponse.getInt("examGrade")));
    }

    public void save(Exam exam) {
        jdbcTemplate.update(
                "INSERT INTO Exam(examName, examDate, examGrade) VALUES(?,?,?)",
                exam.getExamName(), exam.getExamDate(), exam.getExamGrade());
    }

    public void update(Exam exam, String examName) {
        jdbcTemplate.update(
                "UPDATE Exam \n" +
                        "SET examName = ?, examDate = ?,examGrade = ?\n" +
                        "WHERE examName = ?",
                exam.getExamName(), exam.getExamDate(), exam.getExamGrade(),examName);
    }

    public void delete(String examName) {
        jdbcTemplate.update(
                "DELETE FROM Exam WHERE examName = ?", examName );
    }
}
