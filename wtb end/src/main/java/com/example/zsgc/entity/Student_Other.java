package com.example.zsgc.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@Component
//@ConfigurationProperties(prefix = "studentassociation")
public class Student_Other {
    private String student;
    private String association;
    private String position;
    private String dormitory;
    private int bedId;

    public Student_Other(String student, String association, String position, String dormitory, int bedId) {
        this.student = student;
        this.association = association;
        this.position = position;
        this.dormitory = dormitory;
        this.bedId = bedId;
    }

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

    public void setDormitory(String dormitory) {
        this.dormitory = dormitory;
    }

    public String getDormitory() {
        return dormitory;
    }

    public int getBedId() {
        return bedId;
    }

    public void setBedId(int bedId) {
        this.bedId = bedId;
    }

    public String toString() {
        return "Student_Association{" +
                "student='" + student + "'" +
                ", association='" + association + "'" +
                ", position='" + position + "'" +
                ", dormitory='" + dormitory + "'" +
                ", bedId=" + bedId +
                "}";
    }
}
