package com.example.zsgc.entity;

public class Query_Student_Course {
    private String courseId;
    private String name;
    private int credit;
    private String department;

    private String teacher;
    private String classroom;
    private String time;

    private int grade;

    public Query_Student_Course(String courseId, String name, int credit, String department, String teacher, String classroom, String time, int grade) {
        this.courseId = courseId;
        this.name = name;
        this.credit = credit;
        this.department = department;
        this.teacher = teacher;
        this.classroom = classroom;
        this.time = time;
        this.grade = grade;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getTime() {
        return time;
    }

    public String getClassroom() {
        return classroom;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getCredit() {
        return credit;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}
