package com.example.zsgc.entity;

public class Query_Student_Association {
    private String name;    //名称
    private String type;    //类型
    private String stars;   //星级
    private String teacher; //指导老师

    private String position;

    public Query_Student_Association(String name, String type, String stars, String teacher, String position) {
        this.name = name;
        this.type = type;
        this.stars = stars;
        this.teacher = teacher;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
