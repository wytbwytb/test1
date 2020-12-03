package com.example.zsgc.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "course")
public class Course {
    private String courseId;
    private String name;
    private int credit;
    private String department;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String toString() {
        return "Course{" +
                "courseId='" + courseId + "'" +
                ", name='" + name + "'" +
                ", credit=" + credit +
                ", department='" + department + "'" +
                "}";
    }
}
