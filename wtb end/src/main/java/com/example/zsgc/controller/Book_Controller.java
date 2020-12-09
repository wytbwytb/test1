package com.example.zsgc.controller;

import com.example.zsgc.entity.Book;
import com.example.zsgc.mapper.Book_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
    public List<Book> selectByBookId(@RequestBody Book book) {
        return book_mapper.selectByBookId(book);
    }

    @RequestMapping(value = {"/selectByIdOrName"}, method = RequestMethod.POST)
    public List<Book> selectByIdOrName(@RequestBody Book book) {
        return book_mapper.selectByIdOrName(book);
    }

    @RequestMapping(value = {"/selectByState"}, method = RequestMethod.POST)
    public List<Book> selectByState(@RequestBody Book book) {
        return book_mapper.selectByState(book);
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertBook(@RequestBody Book book) {
        book_mapper.insertBook(book);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateBook(@RequestBody Book book) {
        book_mapper.updateBook(book);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.POST)
    public void deleteBook(@RequestBody Book book) {
        book_mapper.deleteBook(book);
    }
}
