package com.example.zsgc.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@Component
//@ConfigurationProperties(prefix = "dormitory")
public class Dormitory {
    private String dormitoryId;
    private String dormitoryBuilding;
    private int floor;
    private String towards;
    private String header;

    public Dormitory(String dormitoryId, String dormitoryBuilding, int floor, String towards, String header) {
        this.dormitoryId = dormitoryId;
        this.dormitoryBuilding = dormitoryBuilding;
        this.floor = floor;
        this.towards = towards;
        this.header = header;
    }

    public String getHeader() {
        return header;
    }

    public int getFloor() {
        return floor;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDormitoryBuilding() {
        return dormitoryBuilding;
    }

    public String getDormitoryId() {
        return dormitoryId;
    }

    public String getTowards() {
        return towards;
    }

    public void setDormitoryBuilding(String dormitoryBuilding) {
        this.dormitoryBuilding = dormitoryBuilding;
    }

    public void setDormitoryId(String dormitoryId) {
        this.dormitoryId = dormitoryId;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setTowards(String towards) {
        this.towards = towards;
    }

    public String toString() {
        return "Dormitory{" +
                "dormitoryId='" + dormitoryId +
                ", dormitoryBuilding='" + dormitoryBuilding + "'" +
                ", floor=" + floor +
                ", towards='" + towards + "'" +
                ", header='" + header + "'" + "'" +
                "}";
    }
}
