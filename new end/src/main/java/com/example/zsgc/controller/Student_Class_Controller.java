package com.example.zsgc.controller;

import com.example.zsgc.entity.Student_Class;
import com.example.zsgc.mapper.Student_Class_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/studentclass")
public class Student_Class_Controller {
    @Autowired
    private Student_Class_Mapper student_class_mapper;

    @RequestMapping(value = {"/selectAll"}, method = RequestMethod.GET)
    public List<Student_Class> selectAll() {
        return student_class_mapper.selectAll();
    }

    @RequestMapping(value = {"/selectByStudent"}, method = RequestMethod.POST)
    public List<Student_Class> selectByStudent(Student_Class student_class) {
        return student_class_mapper.selectByStudent(student_class);
    }

    @RequestMapping(value = {"/selectByAclass"}, method = RequestMethod.POST)
    public List<Student_Class> selectByAclass(Student_Class student_class) {
        return student_class_mapper.selectByAclass(student_class);
    }

    @RequestMapping(value = {"/selectByPosition"}, method = RequestMethod.POST)
    public List<Student_Class> selectByPosition(Student_Class student_class) {
        return student_class_mapper.selectByPosition(student_class);
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertStudent_Class(Student_Class student_class) {
        student_class_mapper.insertStudent_Class(student_class);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateStudent_Class(Student_Class student_class) {
        student_class_mapper.updateStudent_Class(student_class);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.DELETE)
    public void deleteStudent_Class(Student_Class student_class) {
        student_class_mapper.deleteStudent_Class(student_class);
    }
}
