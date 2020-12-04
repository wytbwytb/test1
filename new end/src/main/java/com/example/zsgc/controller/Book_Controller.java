package com.example.zsgc.controller;

import com.example.zsgc.entity.Book;
import com.example.zsgc.mapper.Book_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class Book_Controller {
    @Autowired
    private Book_Mapper book_mapper;

    @RequestMapping(value = {"/selectAll"}, method = RequestMethod.GET)
    public List<Book> selectAll() {
        return book_mapper.selectAll();
    }

    @RequestMapping(value = {"/selectByBookId"}, method = RequestMethod.POST)
    public List<Book> selectByBookId(Book book) {
        return book_mapper.selectByBookId(book);
    }

    @RequestMapping(value = {"/selectByName"}, method = RequestMethod.POST)
    public List<Book> selectByName(Book book) {
        return book_mapper.selectByName(book);
    }

    @RequestMapping(value = {"/selectByState"}, method = RequestMethod.POST)
    public List<Book> selectByState(Book book) {
        return book_mapper.selectByState(book);
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertBook(Book book) {
        book_mapper.insertBook(book);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateBook(Book book) {
        book_mapper.updateBook(book);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.DELETE)
    public void deleteBook(String bookId) {
        book_mapper.deleteBook(bookId);
    }
}
