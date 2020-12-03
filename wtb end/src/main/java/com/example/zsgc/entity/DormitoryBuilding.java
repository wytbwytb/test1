package com.example.zsgc.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "dormitorybuilding")
public class DormitoryBuilding {
    private String dormitoryBuildingId;
    private int floors;
    private int size; //寝室容量
    private String type;
    private String region;
    private String buildDate;

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public int getFloors() {
        return floors;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRegion(String region) {
        this.region = region;
    }


    public String getRegion() {
        return region;
    }

    public int getSize() {
        return size;
    }

    public String getBuildDate() {
        return buildDate;
    }

    public String getDormitoryBuildingId() {
        return dormitoryBuildingId;
    }

    public void setBuildDate(String buildDate) {
        this.buildDate = buildDate;
    }

    public void setDormitoryBuildingId(String dormitoryBuildingId) {
        this.dormitoryBuildingId = dormitoryBuildingId;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String toString() {
        return "DormitoryBuilding{" +
                "dormitoryBuildingId='" + dormitoryBuildingId + "'" +
                ", floors=" + floors  +
                ", size=" + size +
                ", type='" + type + "'" +
                ", region='" + region + "'" +
                ", buildDate=" + buildDate + "'" +
                "}";
    }
}
