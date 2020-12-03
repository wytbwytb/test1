package com.example.zsgc.controller;

import com.example.zsgc.entity.Teacher_Course;
import com.example.zsgc.mapper.Teacher_Course_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teachercourse")
public class Teacher_Course_Controller {
    @Autowired
    private Teacher_Course_Mapper teacher_course_mapper;

    @RequestMapping(value = {"/selectAll"}, method = RequestMethod.GET)
    public List<Teacher_Course> selectAll() {
        return teacher_course_mapper.selectAll();
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertTeacher_Course(Teacher_Course teacher_course) {
        teacher_course_mapper.insertTeacher_Course(teacher_course);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateTeacher_Course(Teacher_Course teacher_course) {
        teacher_course_mapper.updateTeacher_Course(teacher_course);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.DELETE)
    public void deleteTeacher_Course(Teacher_Course teacher_course) {
        teacher_course_mapper.deleteTeacher_Course(teacher_course);
    }
}
