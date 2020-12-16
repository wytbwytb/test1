package com.example.zsgc.entity;

public class Query_special {
    private int same_course;    //名称
    private int same_course_teacher;    //类型
    private int same_association;   //星级
    private int same_dormitoryBuilding; //指导老师
    private int same_dormitoryBuilding_place;
    private int same_book;
    private int same_class;
    private int same_department;

    public Query_special(int same_course, int same_course_teacher, int same_association, int same_dormitoryBuilding, int same_dormitoryBuilding_place, int same_book, int same_class, int same_department) {
        this.same_course = same_course;
        this.same_course_teacher = same_course_teacher;
        this.same_association = same_association;
        this.same_dormitoryBuilding = same_dormitoryBuilding;
        this.same_dormitoryBuilding_place = same_dormitoryBuilding_place;
        this.same_book = same_book;
        this.same_class = same_class;
        this.same_department = same_department;
    }

    public int getSame_course() {
        return same_course;
    }

    public void setSame_course(int same_course) {
        this.same_course = same_course;
    }

    public int getSame_course_teacher() {
        return same_course_teacher;
    }

    public void setSame_course_teacher(int same_course_teacher) {
        this.same_course_teacher = same_course_teacher;
    }

    public int getSame_association() {
        return same_association;
    }

    public void setSame_association(int same_association) {
        this.same_association = same_association;
    }

    public int getSame_dormitoryBuilding() {
        return same_dormitoryBuilding;
    }

    public void setSame_dormitoryBuilding(int same_dormitoryBuilding) {
        this.same_dormitoryBuilding = same_dormitoryBuilding;
    }

    public int getSame_dormitoryBuilding_place() {
        return same_dormitoryBuilding_place;
    }

    public void setSame_dormitoryBuilding_place(int same_dormitoryBuilding_place) {
        this.same_dormitoryBuilding_place = same_dormitoryBuilding_place;
    }

    public int getSame_book() {
        return same_book;
    }

    public void setSame_book(int same_book) {
        this.same_book = same_book;
    }

    public int getSame_class() {
        return same_class;
    }

    public void setSame_class(int same_class) {
        this.same_class = same_class;
    }

    public int getSame_department() {
        return same_department;
    }

    public void setSame_department(int same_department) {
        this.same_department = same_department;
    }
}
