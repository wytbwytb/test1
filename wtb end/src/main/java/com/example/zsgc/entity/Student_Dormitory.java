package com.example.zsgc.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "studentdormitory")
public class Student_Dormitory {
    private String student;
    private String dormitory;
    private int bedId;

    public String getStudent() {
        return student;
    }

    public void setDormitory(String dormitory) {
        this.dormitory = dormitory;
    }

    public void setStudent(String student) {
        this.student = student;
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

    @Override
    public String toString() {
        return "Student_Dormitory{" +
                "student='" + student + "'" +
                ", dormitory='" + dormitory + "'" +
                ", bedId=" + bedId +
                "}";
    }
}
