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
