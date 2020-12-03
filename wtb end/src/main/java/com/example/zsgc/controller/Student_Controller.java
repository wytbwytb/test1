package com.example.zsgc.controller;

import com.example.zsgc.entity.Student;
import com.example.zsgc.mapper.Student_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class Student_Controller {
    @Autowired
    private Student_Mapper student_mapper;

    @RequestMapping(value = {"/selectAll"}, method = RequestMethod.GET)
    public List<Student> selectAll() {
        return student_mapper.selectAll();
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertStudent(Student student) {
        student_mapper.insertStudent(student);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateStudent(Student student) {
        student_mapper.updateStudent(student);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.DELETE)
    public void deleteStudent(String studentId) {
        student_mapper.deleteStudent(studentId);
    }
}
