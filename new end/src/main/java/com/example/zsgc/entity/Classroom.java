package com.example.zsgc.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@Component
//@ConfigurationProperties(prefix = "classroom")
public class Classroom {
    private String classroomId;
    private String teachingBuilding;
    private int floors;
    private String type;

    public Classroom(String classroomId, String teachingBuilding, int floors, String type) {
        this.classroomId = classroomId;
        this.teachingBuilding = teachingBuilding;
        this.floors = floors;
        this.type = type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTeachingBuilding() {
        return teachingBuilding;
    }

    public String getType() {
        return type;
    }

    public int getFloors() {
        return floors;
    }

    public String getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(String classroomId) {
        this.classroomId = classroomId;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public void setTeachingBuilding(String teachingBuilding) {
        this.teachingBuilding = teachingBuilding;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "classroomId='" + classroomId + "'" +
                ", teachingBuilding='" + teachingBuilding + "'" +
                ", floors=" + floors +
                ", type='" + type + "'" +
                "}";
    }
}
