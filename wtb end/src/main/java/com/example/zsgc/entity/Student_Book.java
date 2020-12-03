package com.example.zsgc.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "studentbook")
public class Student_Book {
    private String student;
    private String book;
    private String borrowDate;
    private String state;

    public void setStudent(String student) {
        this.student = student;
    }

    public String getStudent() {
        return student;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public String getBook() {
        return book;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String toString() {
        return "Student_Book{" +
                "student='" + student + "'" +
                ", book='" + book + "'" +
                ", borrowDate='" + borrowDate + "'" +
                ", state='" + state + "'" +
                "}";
    }
}
