package com.school.project.classes;

public class Teacher {
    private int teacherId;
    private String firstName;
    private String lastName;
    private String telephoneNumber;
    private String taughtCourse;

    public Teacher(int teacherId, String firstName, String lastName, String telephoneNumber, String taughtCourse) {
        this.teacherId = teacherId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.taughtCourse = taughtCourse;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getTaughtCourse() {
        return taughtCourse;
    }

    public void setTaughtCourse(String taughtCourse) {
        this.taughtCourse = taughtCourse;
    }
}