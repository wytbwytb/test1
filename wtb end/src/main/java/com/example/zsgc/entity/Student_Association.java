package com.example.zsgc.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "studentassociation")
public class Student_Association {
    private String student;
    private String association;
    private String position;

    public String getAssociation() {
        return association;
    }

    public String getStudent() {
        return student;
    }

    public String getPosition() {
        return position;
    }

    public void setAssociation(String association) {
        this.association = association;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String toString() {
        return "Student_Association{" +
                "student='" + student + "'" +
                ", association='" + association + "'" +
                ", position='" + position + "'" +
                "}";
    }
}
