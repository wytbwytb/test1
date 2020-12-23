package com.example.zsgc.controller;

import com.example.zsgc.entity.Course;
import com.example.zsgc.entity.CourseT;
import com.example.zsgc.entity.Student_Course;
import com.example.zsgc.mapper.Course_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping(value = {"/selectAlll"}, method = RequestMethod.GET)
    public List<CourseT> selectAlll() {
        return course_mapper.selectAlll();
    }

    @RequestMapping(value = {"/selectByIdOrName"}, method = RequestMethod.POST)
    public List<Course> selectByIdOrName(@RequestBody Course course) {
        return course_mapper.selectByIdOrName(course);
    }

    @RequestMapping(value = {"/selectByIdOrName2"}, method = RequestMethod.POST)
    public List<CourseT> selectByIdOrName2(@RequestBody Course course) {
        return course_mapper.selectByIdOrName2(course);
    }

    @RequestMapping(value = {"/selectByName"}, method = RequestMethod.POST)
    public List<Course> selectByName(@RequestBody Course course) {
        return course_mapper.selectByName(course);
    }

    @RequestMapping(value = {"/selectByDepartment"}, method = RequestMethod.POST)
    public List<Course> selectByDepartment(@RequestBody Course course) {
        return course_mapper.selectByDepartment(course);
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertCourse(@RequestBody Course course) {
        course_mapper.insertCourse(course);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateCourse(@RequestBody Course course) {
        course_mapper.updateCourse(course);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.POST)
    public void deleteCourse(@RequestBody Course course) {
        course_mapper.deleteCourse(course);
    }
}
