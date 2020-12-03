package com.example.zsgc.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "user")
public class User {
    private String userName;
    private String passwords;
    private String type;
    private String id;

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPasswords() {
        return passwords;
    }

    public String getUserName() {
        return userName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "userName='" + userName + "'" +
                ", passwords='" + passwords + "'" +
                ", type='" + type + "'" +
                ", id='" + id + "'" +
                "}";
    }
}
