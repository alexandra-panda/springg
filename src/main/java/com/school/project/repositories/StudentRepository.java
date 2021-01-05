package com.school.project.repositories;

import com.school.project.classes.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Student> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM Student",
                (reponse, rownumber) ->
                        new Student(reponse.getInt("studentid"),
                                reponse.getString("firstName"),
                                reponse.getString("lastname"),
                                reponse.getString("gender"),
                                reponse.getString("group"),
                                reponse.getDouble("average")));
    }

    public Student findById(int studentId) {
        String sql = "SELECT *FROM Student WHERE studentId = ?;";
        Object[] inputs = new Object[] {studentId};

        return jdbcTemplate.queryForObject(
                sql,
                inputs,
                (reponse, rownumber) ->new Student (reponse.getInt("studentid"),
                        reponse.getString("firstName"),
                        reponse.getString("lastname"),
                        reponse.getString("gender"),
                        reponse.getString("group"),
                        reponse.getDouble("average")));
    }

    public void save(Student student) {
        jdbcTemplate.update(
                "INSERT INTO Student(firstName, lastName, gender, \"group\", average) VALUES(?,?,?,?,?)",
                student.getFirstName(), student.getLastName(), student.getGender(), student.getGroup(), student.getAverage());
    }

    public void update(Student student, String firstName) {
        jdbcTemplate.update(
                "UPDATE Student\n" +
                        "SET firstName = ?, lastName = ?,gender = ?,\"group\" = ?, average = ?\n" +
                        "WHERE firstName = ?",
                student.getFirstName(), student.getLastName(), student.getGender(), student.getGroup(), student.getAverage(),firstName);
    }

    public void delete(String firstName) {
        jdbcTemplate.update(
                "DELETE FROM Student WHERE firstName = ?", firstName);
    }


}