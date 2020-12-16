package com.example.zsgc.entity;

public class StudentDouble {
    private String studentId1;
    private String name1;
    private String studentId2;
    private String name2;

    public StudentDouble(String studentId1, String name1, String studentId2, String name2) {
        this.studentId1 = studentId1;
        this.name1 = name1;
        this.studentId2 = studentId2;
        this.name2 = name2;
    }

    public String getStudentId1() {
        return studentId1;
    }

    public void setStudentId1(String studentId1) {
        this.studentId1 = studentId1;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getStudentId2() {
        return studentId2;
    }

    public void setStudentId2(String studentId2) {
        this.studentId2 = studentId2;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }
}
