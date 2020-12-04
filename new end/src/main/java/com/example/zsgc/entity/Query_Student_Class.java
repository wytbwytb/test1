package com.example.zsgc.entity;

public class Query_Student_Class {
    private String department;
    private String dHeader;

    private String classId;
    private String cHeader;      //班主任
    private String counsellor;  //辅导员

    private String position;

    public Query_Student_Class(String department, String dHeader, String classId, String cHeader, String counsellor, String position) {
        this.department = department;
        this.dHeader = dHeader;
        this.classId = classId;
        this.cHeader = cHeader;
        this.counsellor = counsellor;
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setCounsellor(String counsellor) {
        this.counsellor = counsellor;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getCounsellor() {
        return counsellor;
    }

    public String getClassId() {
        return classId;
    }

    public String getcHeader() {
        return cHeader;
    }

    public String getdHeader() {
        return dHeader;
    }

    public void setcHeader(String cHeader) {
        this.cHeader = cHeader;
    }

    public void setdHeader(String dHeader) {
        this.dHeader = dHeader;
    }
}
