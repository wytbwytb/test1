package com.example.zsgc.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@Component
//@ConfigurationProperties(prefix = "staffdormitorybuilding")
public class Staff_DormitoryBuilding {
    private String staff;
    private String dormitory;

    public Staff_DormitoryBuilding(String staff, String dormitory) {
        this.staff = staff;
        this.dormitory = dormitory;
    }

    public String getDormitory() {
        return dormitory;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }

    public String getStaff() {
        return staff;
    }

    public void setDormitory(String dormitory) {
        this.dormitory = dormitory;
    }

    @Override
    public String toString() {
        return "Staff_Dormitory{" +
                "staff='" + staff + "'" +
                ", dormitory='" + dormitory + "'" +
                "}";
    }
}
