package com.example.zsgc.controller;

import com.example.zsgc.entity.Student_Book;
import com.example.zsgc.mapper.Student_Book_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/studentbook")
public class Student_Book_Controller {
    @Autowired
    private Student_Book_Mapper student_book_mapper;

    @RequestMapping(value = {"/selectAll"}, method = RequestMethod.GET)
    public List<Student_Book> selectAll() {
        return student_book_mapper.selectAll();
    }

    @RequestMapping(value = {"/selectByStudent"}, method = RequestMethod.POST)
    public List<Student_Book> selectByStudent(Student_Book student_book) {
        return student_book_mapper.selectByStudent(student_book);
    }

    @RequestMapping(value = {"/selectByBook"}, method = RequestMethod.POST)
    public List<Student_Book> selectByBook(Student_Book student_book) {
        return student_book_mapper.selectByBook(student_book);
    }

    @RequestMapping(value = {"/selectByBorrowDate"}, method = RequestMethod.POST)
    public List<Student_Book> selectByBorrowDate(Student_Book student_book) {
        return student_book_mapper.selectByBorrowDate(student_book);
    }

    @RequestMapping(value = {"/selectByState"}, method = RequestMethod.POST)
    public List<Student_Book> selectByState(Student_Book student_book) {
        return student_book_mapper.selectByState(student_book);
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertStudent_Book(Student_Book student_book) {
        student_book_mapper.insertStudent_Book(student_book);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateStudent_Book(Student_Book student_book) {
        student_book_mapper.updateStudent_Book(student_book);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.DELETE)
    public void deleteStudent_Book(Student_Book student_book) {
        student_book_mapper.deleteStudent_Book(student_book);
    }
}
