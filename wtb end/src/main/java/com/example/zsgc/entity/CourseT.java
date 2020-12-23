package com.example.zsgc.entity;

//@Component
//@ConfigurationProperties(prefix = "course")
public class CourseT {
    private String courseId;
    private String name;
    private int credit;
    private String department;
    private String teacher;

    public CourseT(String courseId, String name, int credit, String department, String teacher) {
        this.courseId = courseId;
        this.name = name;
        this.credit = credit;
        this.department = department;
        this.teacher = teacher;
    }

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

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
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
