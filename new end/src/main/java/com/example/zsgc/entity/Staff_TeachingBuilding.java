package com.example.zsgc.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@Component
//@ConfigurationProperties(prefix = "staffteachingbuilding")
public class Staff_TeachingBuilding {
    private String staff;
    private String teachingBuilding;

    public Staff_TeachingBuilding(String staff, String teachingBuilding) {
        this.staff = staff;
        this.teachingBuilding = teachingBuilding;
    }

    public String getTeachingBuilding() {
        return teachingBuilding;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }

    public String getStaff() {
        return staff;
    }

    public void setTeachingBuilding(String teachingBuilding) {
        this.teachingBuilding = teachingBuilding;
    }

    @Override
    public String toString() {
        return "Staff_TeachingBuilding{" +
                "staff='" + staff + "'" +
                ", teachingBuilding='" + teachingBuilding + "'" +
                "}";
    }
}
