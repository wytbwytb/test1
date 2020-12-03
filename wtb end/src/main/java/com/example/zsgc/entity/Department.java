package com.example.zsgc.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "department")
public class Department {
    private String departmentId;
    private String name;
    private String header;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getHeader() {
        return header;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String toString() {
        return "Student{" +
                "departmentId='" + departmentId + "'" +
                ", name='" + name + "'" +
                ", header='" + header + "'" +
                "}";
    }
}
