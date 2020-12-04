package com.example.zsgc.controller;

import com.example.zsgc.entity.*;
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

    @RequestMapping(value = {"/selectByStudentId"}, method = RequestMethod.POST)
    public List<Student> selectByStudentId(Student student) {
        return student_mapper.selectByStudentId(student);
    }

    @RequestMapping(value = {"/selectByName"}, method = RequestMethod.POST)
    public List<Student> selectByName(Student student) {
        return student_mapper.selectByName(student);
    }

    @RequestMapping(value = {"/selectByGender"}, method = RequestMethod.POST)
    public List<Student> selectByGender(Student student) {
        return student_mapper.selectByGender(student);
    }

    @RequestMapping(value = {"/queryDormitory"}, method = RequestMethod.POST)
    public List<Query_Student_Dormitory> queryDormitory(Student student) {
        return student_mapper.queryDormitory(student);
    }

    @RequestMapping(value = {"/queryCourse"}, method = RequestMethod.POST)
    public List<Query_Student_Course> queryCourse(Student student) {
        return student_mapper.queryCourse(student);
    }

    @RequestMapping(value = {"/queryClass"}, method = RequestMethod.POST)
    public List<Query_Student_Class> queryClass(Student student) {
        return student_mapper.queryClass(student);
    }

    @RequestMapping(value = {"/queryBook"}, method = RequestMethod.POST)
    public List<Query_Student_Book> queryBook(Student student) {
        return student_mapper.queryBook(student);
    }

    @RequestMapping(value = {"/queryAssociation"}, method = RequestMethod.POST)
    public List<Query_Student_Association> queryAssociation(Student student) {
        return student_mapper.queryAssociation(student);
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
