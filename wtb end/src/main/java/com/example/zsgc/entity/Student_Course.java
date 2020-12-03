package com.example.zsgc.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "studentcourse")
public class Student_Course {
    private String student;
    private String course;
    private String teacher;
    private int grade;

    public void setStudent(String student) {
        this.student = student;
    }

    public String getStudent() {
        return student;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getTeacher() {
        return teacher;
    }

    public int getGrade() {
        return grade;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student_Course{" +
                "student='" + student + "'" +
                ", course='" + course + "'" +
                ", teacher='" + teacher + "'" +
                ", grade=" + grade +
                '}';
    }
}
