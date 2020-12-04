package com.example.zsgc.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@Component
//@ConfigurationProperties(prefix = "student")
public class Student {
    private String studentId;
    private String name;
    private String gender;
    private String region;
    private int age;

    public Student(String studentId, String name, String gender, String region, int age) {
        this.studentId = studentId;
        this.name = name;
        this.gender = gender;
        this.region = region;
        this.age = age;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + "'" +
                ", name='" + name + "'" +
                ", gender='" + gender + "'" +
                ", region='" + region + "'" +
                ", age=" + age +
                "}";
    }
}
