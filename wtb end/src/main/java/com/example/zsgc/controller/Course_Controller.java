package com.example.zsgc.controller;

import com.example.zsgc.entity.Course;
import com.example.zsgc.mapper.Course_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class Course_Controller {
    @Autowired
    private Course_Mapper course_mapper;

    @RequestMapping(value = {"/selectAll"}, method = RequestMethod.GET)
    public List<Course> selectAll() {
        return course_mapper.selectAll();
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertCourse(Course course) {
        course_mapper.insertCourse(course);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateCourse(Course course) {
        course_mapper.updateCourse(course);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.DELETE)
    public void deleteCourse(String courseId) {
        course_mapper.deleteCourse(courseId);
    }
}
