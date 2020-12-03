package com.example.zsgc.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "staff")
public class Staff {
    private String staffId;
    private String name;
    private String gender;
    private int age;
    private String region;
    private int workAge;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getWorkAge() {
        return workAge;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public void setWorkAge(int workAge) {
        this.workAge = workAge;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffId='" + staffId + "'" +
                ", name='" + name + "'" +
                ", gender='" + gender + "'" +
                ", region='" + region + "'" +
                ", age=" + age +
                ", workAge=" + workAge +
                "}";
    }
}


