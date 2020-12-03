package com.example.zsgc.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "teachingbuilding")
public class TeachingBuilding {
    private String name;
    private String region;
    private int floors;
    private int buildDate;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }

    public void setBuildDate(int buildDate) {
        this.buildDate = buildDate;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public int getBuildDate() {
        return buildDate;
    }

    @Override
    public String toString() {
        return "TeachingBuilding{" +
                "name='" + name + "'" +
                ", region='" + region + "'" +
                ", floors=" + floors +
                ", buildDate=" + buildDate +
                "}";
    }
}
