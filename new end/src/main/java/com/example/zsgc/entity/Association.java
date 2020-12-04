package com.example.zsgc.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@Component
//@ConfigurationProperties(prefix = "association")
public class Association {
    private String name;    //名称
    private String type;    //类型
    private String stars;   //星级
    private String teacher; //指导老师

    public Association(String name, String type, String stars, String teacher) {
        this.name = name;
        this.type = type;
        this.stars = stars;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStars() {
        return stars;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getType() {
        return type;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Association{" +
                "name='" + name + "'" +
                ", type='" + type + "'" +
                ", stars='" + stars + "'" +
                ", teacher='" + teacher + "'" +
                "}";
    }
}
