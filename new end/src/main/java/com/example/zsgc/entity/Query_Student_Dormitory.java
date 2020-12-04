package com.example.zsgc.entity;

public class Query_Student_Dormitory {
    private String dormitoryId;
    private String dormitoryBuilding;
    private String region;
    private int floor;
    private String master;//宿舍长
    private String towards;
    private int bedId;

    public Query_Student_Dormitory(String dormitoryId, String dormitoryBuilding, String region, int floor, String master, String towards, int bedId) {
        this.dormitoryId = dormitoryId;
        this.dormitoryBuilding = dormitoryBuilding;
        this.region = region;
        this.floor = floor;
        this.master = master;
        this.towards = towards;
        this.bedId = bedId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setBedId(int bedId) {
        this.bedId = bedId;
    }

    public int getBedId() {
        return bedId;
    }

    public void setTowards(String towards) {
        this.towards = towards;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setDormitoryId(String dormitoryId) {
        this.dormitoryId = dormitoryId;
    }

    public void setDormitoryBuilding(String dormitoryBuilding) {
        this.dormitoryBuilding = dormitoryBuilding;
    }

    public String getTowards() {
        return towards;
    }

    public String getDormitoryId() {
        return dormitoryId;
    }

    public String getDormitoryBuilding() {
        return dormitoryBuilding;
    }

    public int getFloor() {
        return floor;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }
}
