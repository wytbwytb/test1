package com.example.zsgc.controller;

import com.example.zsgc.entity.Query_Teacher_StudentGrade;
import com.example.zsgc.entity.Teacher_Course;
import com.example.zsgc.mapper.Teacher_Course_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping(value = {"/selectByCourse"}, method = RequestMethod.POST)
    public List<Teacher_Course> selectByCourse(@RequestBody Teacher_Course teacher_course) {
        return teacher_course_mapper.selectByCourse(teacher_course);
    }

    @RequestMapping(value = {"/selectByTeacher"}, method = RequestMethod.POST)
    public List<Teacher_Course> selectByTeacher(@RequestBody Teacher_Course teacher_course) {
        return teacher_course_mapper.selectByTeacher(teacher_course);
    }

    @RequestMapping(value = {"/selectByClassroom"}, method = RequestMethod.POST)
    public List<Teacher_Course> selectByClassroom(@RequestBody Teacher_Course teacher_course) {
        return teacher_course_mapper.selectByClassroom(teacher_course);
    }

    @RequestMapping(value = {"/selectByTime"}, method = RequestMethod.POST)
    public List<Teacher_Course> selectByTime(@RequestBody Teacher_Course teacher_course) {
        return teacher_course_mapper.selectByTime(teacher_course);
    }

    @RequestMapping(value = {"/queryCourseGrade"}, method = RequestMethod.POST)
    public List<Query_Teacher_StudentGrade> queryCourseGrade(@RequestBody Teacher_Course teacher_course) {
        return teacher_course_mapper.queryCourseGrade(teacher_course);
    }

    @RequestMapping(value = {"/queryAllGrade"}, method = RequestMethod.POST)
    public List<Query_Teacher_StudentGrade> queryAllGrade(@RequestBody Teacher_Course teacher_course) {
        return teacher_course_mapper.queryAllGrade(teacher_course);
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertTeacher_Course(@RequestBody Teacher_Course teacher_course) {
        teacher_course_mapper.insertTeacher_Course(teacher_course);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateTeacher_Course(@RequestBody Teacher_Course teacher_course) {
        teacher_course_mapper.updateTeacher_Course(teacher_course);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.POST)
    public void deleteTeacher_Course(@RequestBody Teacher_Course teacher_course) {
        teacher_course_mapper.deleteTeacher_Course(teacher_course);
    }
}
