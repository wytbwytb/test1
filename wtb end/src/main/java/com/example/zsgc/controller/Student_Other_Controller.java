package com.example.zsgc.controller;

import com.example.zsgc.entity.Student_Other;
import com.example.zsgc.mapper.Student_Other_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/studentother")
public class Student_Other_Controller {
    @Autowired
    private Student_Other_Mapper student_association_mapper;

    @RequestMapping(value = {"/selectAll"}, method = RequestMethod.GET)
    public List<Student_Other> selectAll() {
        return student_association_mapper.selectAll();
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertStudent_Association(@RequestBody Student_Other student_association) {
        student_association_mapper.insertStudent_Association(student_association);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateStudent_Association(@RequestBody Student_Other student_association) {
        student_association_mapper.updateStudent_Association(student_association);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.POST)
    public void deleteStudent_Association(@RequestBody Student_Other student_association) {
        student_association_mapper.deleteStudent_Association(student_association);
    }
}
