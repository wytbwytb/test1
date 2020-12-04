package com.example.zsgc.entity;

public class Query_Teacher_StudentGrade {
    private String StudentId;
    private String StudentName;
    private String CourseId;
    private int grade;

    public Query_Teacher_StudentGrade(String studentId, String studentName, String courseId, int grade) {
        StudentId = studentId;
        StudentName = studentName;
        CourseId = courseId;
        this.grade = grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public void setCourseId(String courseId) {
        CourseId = courseId;
    }

    public String getCourseId() {
        return CourseId;
    }

    public void setStudentId(String studentId) {
        StudentId = studentId;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getStudentId() {
        return StudentId;
    }
}
