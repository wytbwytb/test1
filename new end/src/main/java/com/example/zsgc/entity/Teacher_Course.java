package com.example.zsgc.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@Component
//@ConfigurationProperties(prefix = "teachercourse")
public class Teacher_Course {
    private String course;
    private String teacher;
    private String classroom;
    private String time;

    public Teacher_Course(String course, String teacher, String classroom, String time) {
        this.course = course;
        this.teacher = teacher;
        this.classroom = classroom;
        this.time = time;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getClassroom() {
        return classroom;
    }

    public String getTime() {
        return time;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Teacher_Course{" +
                "course='" + course + "'" +
                ", teacher='" + teacher + "'" +
                ", classroom='" + classroom + "'" +
                ", time='" + time + "'" +
                "}";
    }
}
