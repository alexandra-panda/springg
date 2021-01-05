CREATE DATABASE schoolRelational;
CREATE TABLE Student
(
    studentId serial primary key,
    firstName varchar(15) not null,
    lastName  varchar(15) not null,
    gender    varchar(15) not null,
    "group"   varchar(15) not null,
    average   float       not null
);
CREATE TABLE Teacher
(
    teacherId       serial primary key,
    firstName       varchar(15) not null,
    lastName        varchar(15) not null,
    telephoneNumber varchar(15) not null,
    taughtCourse    varchar(15) not null
);

CREATE TABLE Exam
(
    examId    serial primary key,
    examName  varchar(15) not null,
    examDate  date        not null,
    examGrade int         not null,
    studentId int UNIQUE ,
    FOREIGN KEY (studentId) REFERENCES Student (studentId)
);

INSERT INTO Student(firstName, lastName, gender, "group", average) VALUES ('Teodor','Vrabie','male','Fi-181',9);
INSERT INTO Student(firstName, lastName, gender, "group", average) VALUES ('Andrei','Lovru','male','Fi-181',6);
INSERT INTO Exam(examName, examDate, examGrade,studentId) VALUES ('informatica','2019-06-01',10,2);
INSERT INTO Teacher(firstName, lastName, telephoneNumber, taughtCourse) VALUES ('Anatolie','Balabanov','079897754','CDE');
INSERT INTO Exam(examName, examDate, examGrade,studentId) VALUES ('matematica','2019-06-01',10,1);


SELECT *FROM Student;
SELECT *FROM Teacher;
SELECT *FROM Exam;

SELECT Student.*, Exam.examName, Exam.examDate, Exam.examGrade FROM Student
INNER JOIN Exam
ON Exam.examId = Student.studentId;

SELECT Student.*, Exam.examName, Exam.examDate, Exam.examGrade FROM Student
INNER JOIN Exam
ON Exam.examId = Student.studentId
WHERE gender = 'male' AND examGrade = 10;


DROP DATABASE schoolRelational
