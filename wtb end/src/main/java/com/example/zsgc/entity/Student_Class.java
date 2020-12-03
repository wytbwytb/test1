package com.example.zsgc.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "studentclass")
public class Student_Class {
    private String student;
    private String aclass;
    private String position;

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setAclass(String aclass) {
        this.aclass = aclass;
    }

    public String getAclass() {
        return aclass;
    }

    public String toString() {
        return "Student_Class{" +
                "student='" + student + "'" +
                ", class_='" + aclass + "'" +
                ", position='" + position + "'" +
                "}";
    }
}
