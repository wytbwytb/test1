package com.example.zsgc.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@Component
//@ConfigurationProperties(prefix = "class")
public class Class {
    private String classId;
    private String department;
    private String header;      //班主任
    private String counsellor;  //辅导员

    public Class(String classId, String department, String header, String counsellor) {
        this.classId = classId;
        this.department = department;
        this.header = header;
        this.counsellor = counsellor;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public String getClassId() {
        return classId;
    }

    public String getCounsellor() {
        return counsellor;
    }

    public String getHeader() {
        return header;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public void setCounsellor(String counsellor) {
        this.counsellor = counsellor;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    @Override
    public String toString() {
        return "Class{" +
                "classId='" + classId + "'" +
                ", department='" + department + "'" +
                ", header='" + header + "'" +
                ", counsellor='" + counsellor + "'" +
                "}";
    }
}
