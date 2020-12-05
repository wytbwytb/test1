package com.example.zsgc.controller;

import com.example.zsgc.entity.Teacher;
import com.example.zsgc.mapper.Teacher_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping(value = {"/selectByIdOrName"}, method = RequestMethod.POST)
    public List<Teacher> selectByIdOrName(@RequestBody Teacher teacher) {
        return teacher_mapper.selectByIdOrName(teacher);
    }

    @RequestMapping(value = {"/selectByName"}, method = RequestMethod.POST)
    public List<Teacher> selectByName(@RequestBody Teacher teacher) {
        return teacher_mapper.selectByName(teacher);
    }

    @RequestMapping(value = {"/selectByGender"}, method = RequestMethod.POST)
    public List<Teacher> selectByGender(@RequestBody Teacher teacher) {
        return teacher_mapper.selectByGender(teacher);
    }

    @RequestMapping(value = {"/selectByDepartment"}, method = RequestMethod.POST)
    public List<Teacher> selectByDepartment(@RequestBody Teacher teacher) {
        return teacher_mapper.selectByDepartment(teacher);
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertTeacher(@RequestBody Teacher teacher) {
        teacher_mapper.insertTeacher(teacher);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateTeacher(@RequestBody Teacher teacher) {
        teacher_mapper.updateTeacher(teacher);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.POST)
    public void deleteTeacher(@RequestBody Teacher teacher) {
        teacher_mapper.deleteTeacher(teacher);
    }
}
