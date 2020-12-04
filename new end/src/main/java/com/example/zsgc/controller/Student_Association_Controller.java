package com.example.zsgc.controller;

import com.example.zsgc.entity.Student_Association;
import com.example.zsgc.mapper.Student_Association_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/studentassociation")
public class Student_Association_Controller {
    @Autowired
    private Student_Association_Mapper student_association_mapper;

    @RequestMapping(value = {"/selectAll"}, method = RequestMethod.GET)
    public List<Student_Association> selectAll() {
        return student_association_mapper.selectAll();
    }

    @RequestMapping(value = {"/selectByStudent"}, method = RequestMethod.POST)
    public List<Student_Association> selectByStudent(Student_Association student_association) {
        return student_association_mapper.selectByStudent(student_association);
    }

    @RequestMapping(value = {"/selectByAssociation"}, method = RequestMethod.POST)
    public List<Student_Association> selectByAssociation(Student_Association student_association) {
        return student_association_mapper.selectByAssociation(student_association);
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertStudent_Association(Student_Association student_association) {
        student_association_mapper.insertStudent_Association(student_association);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateStudent_Association(Student_Association student_association) {
        student_association_mapper.updateStudent_Association(student_association);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.DELETE)
    public void deleteStudent_Association(Student_Association student_association) {
        student_association_mapper.deleteStudent_Association(student_association);
    }
}
