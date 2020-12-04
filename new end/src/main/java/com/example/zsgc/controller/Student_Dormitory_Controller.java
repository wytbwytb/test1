package com.example.zsgc.controller;

import com.example.zsgc.entity.Student_Dormitory;
import com.example.zsgc.mapper.Student_Dormitory_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/studentdormitory")
public class Student_Dormitory_Controller {
    @Autowired
    private Student_Dormitory_Mapper student_dormitory_mapper;

    @RequestMapping(value = {"/selectAll"}, method = RequestMethod.GET)
    public List<Student_Dormitory> selectAll() {
        return student_dormitory_mapper.selectAll();
    }

    @RequestMapping(value = {"/selectByStudent"}, method = RequestMethod.POST)
    public List<Student_Dormitory> selectByStudent(Student_Dormitory student_dormitory) {
        return student_dormitory_mapper.selectByStudent(student_dormitory);
    }

    @RequestMapping(value = {"/selectByDormitory"}, method = RequestMethod.POST)
    public List<Student_Dormitory> selectByDormitory(Student_Dormitory student_dormitory) {
        return student_dormitory_mapper.selectByDormitory(student_dormitory);
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertStudent_Dormitory(Student_Dormitory student_dormitory) {
        student_dormitory_mapper.insertStudent_Dormitory(student_dormitory);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateStudent_Dormitory(Student_Dormitory student_dormitory) {
        student_dormitory_mapper.updateStudent_Dormitory(student_dormitory);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.DELETE)
    public void deleteStudent_Dormitory(Student_Dormitory student_dormitory) {
        student_dormitory_mapper.deleteStudent_Dormitory(student_dormitory);
    }
}
