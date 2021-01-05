package com.school.project.repositories;

import com.school.project.classes.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Teacher> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM Teacher",
                (reponse, rownumber) ->
                        new Teacher(reponse.getInt("teacherId"),
                                reponse.getString("firstName"),
                                reponse.getString("lastname"),
                                reponse.getString("telephoneNumber"),
                                reponse.getString("taughtCourse")));
    }

    public Teacher findById(int teacherId) {
        String sql = "SELECT *FROM Teacher WHERE teacherId = ?;";
        Object[] inputs = new Object[] {teacherId};

        return jdbcTemplate.queryForObject(
                sql,
                inputs,
                (reponse, rownumber) ->new Teacher (reponse.getInt("teacherId"),
                        reponse.getString("firstName"),
                        reponse.getString("lastname"),
                        reponse.getString("telephoneNumber"),
                        reponse.getString("taughtCourse")));
    }


    public void save(Teacher teacher) {
        jdbcTemplate.update(
                "INSERT INTO Teacher(firstName, lastName, telephoneNumber, taughtCourse) VALUES(?,?,?,?)",
                teacher.getFirstName(), teacher.getLastName(), teacher.getTelephoneNumber(), teacher.getTaughtCourse());
    }

    public void update(Teacher teacher, String firstName) {
        jdbcTemplate.update(
                "UPDATE Teacher \n" +
                        "SET firstName = ?, lastName = ?,telephoneNumber = ?, taughtCourse = ?\n" +
                        "WHERE firstName = ?",
                teacher.getFirstName(), teacher.getLastName(), teacher.getTelephoneNumber(), teacher.getTaughtCourse(),firstName);
    }

    public void delete(String firstName) {
        jdbcTemplate.update(
                "DELETE FROM Teacher WHERE firstName = ?", firstName);
    }
}
