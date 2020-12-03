package com.example.zsgc.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "teacher")
public class Teacher {
    private String teacherId;
    private String name;
    private String gender;
    private int age;
    private String region;
    private String email;
    private int teachingAge;    //教龄
    private String department; //院系
    private String title;   //职称

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public int getTeachingAge() {
        return teachingAge;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public String getTitle() {
        return title;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public void setTeachingAge(int teachingAge) {
        this.teachingAge = teachingAge;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId='" + teacherId +
                ", name='" + name + "'" +
                ", gender='" + gender + "'" +
                ", age=" + age +
                ", region='" + region + "'" +
                ", email='" + email + "'" +
                ", teacherAge=" + teachingAge +
                ", department='" + department + "'" +
                ", title='" + title + "'" +
                "}";
    }
}
