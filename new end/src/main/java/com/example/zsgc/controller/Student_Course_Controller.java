package com.example.zsgc.controller;

import com.example.zsgc.entity.Student_Course;
import com.example.zsgc.mapper.Student_Course_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/studentcourse")
public class Student_Course_Controller {
    @Autowired
    private Student_Course_Mapper student_course_mapper;

    @RequestMapping(value = {"/selectAll"}, method = RequestMethod.GET)
    public List<Student_Course> selectAll() {
        return student_course_mapper.selectAll();
    }

    @RequestMapping(value = {"/selectByStudent"}, method = RequestMethod.POST)
    public List<Student_Course> selectByStudent(Student_Course student_course) {
        return student_course_mapper.selectByStudent(student_course);
    }

    @RequestMapping(value = {"/selectByCourseAndTeacher"}, method = RequestMethod.POST)
    public List<Student_Course> selectByCourseAndTeacher(Student_Course student_course) {
        return student_course_mapper.selectByCourseAndTeacher(student_course);
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertStudent_Course(Student_Course student_course) {
        student_course_mapper.insertStudent_Course(student_course);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateStudent_Course(Student_Course student_course) {
        student_course_mapper.updateStudent_Course(student_course);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.DELETE)
    public void deleteStudent_Course(Student_Course student_course) {
        student_course_mapper.deleteStudent_Course(student_course);
    }
}
