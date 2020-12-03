package com.example.zsgc.controller;

import com.example.zsgc.entity.Teacher;
import com.example.zsgc.mapper.Teacher_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class Teacher_Controller {
    @Autowired
    private Teacher_Mapper teacher_mapper;

    @RequestMapping(value = {"/selectAll"}, method = RequestMethod.GET)
    public List<Teacher> selectAll() {
        return teacher_mapper.selectAll();
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertTeacher(Teacher teacher) {
        teacher_mapper.insertTeacher(teacher);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateTeacher(Teacher teacher) {
        teacher_mapper.updateTeacher(teacher);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.DELETE)
    public void deleteTeacher(String teacherId) {
        teacher_mapper.deleteTeacher(teacherId);
    }
}
