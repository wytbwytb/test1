package com.example.zsgc.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@Component
//@ConfigurationProperties(prefix = "book")
public class Book {
    private String bookId;
    private String name;
    private String author;
    private String publisher;
    private int publishDate;
    private String state;

    public Book(String bookId, String name, String author, String publisher, int publishDate, String state)
    {
        this.bookId=bookId;
        this.name=name;
        this.author=author;
        this.publisher=publisher;
        this.publishDate=publishDate;
        this.state=state;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPublishDate() {
        return publishDate;
    }

    public String getAuthor() {
        return author;
    }

    public String getBookId() {
        return bookId;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getState() {
        return state;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setPublishDate(int publishDate) {
        this.publishDate = publishDate;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + "'" +
                ", name='" + name + "'" +
                ", author='" + author + "'" +
                ", publisher='" + publisher + "'" +
                ", publishDate=" + publishDate +
                ", state='" + state + "'" +
                "}";
    }
}
