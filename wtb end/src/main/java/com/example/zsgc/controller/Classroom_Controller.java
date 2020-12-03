package com.example.zsgc.controller;

import com.example.zsgc.entity.Classroom;
import com.example.zsgc.mapper.Classroom_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/classroom")
public class Classroom_Controller {
    @Autowired
    private Classroom_Mapper classroom_mapper;

    @RequestMapping(value = {"/selectAll"}, method = RequestMethod.GET)
    public List<Classroom> selectAll() {
        return classroom_mapper.selectAll();
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertClassroom(Classroom classroom) {
        classroom_mapper.insertClassroom(classroom);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateClassroom(Classroom classroom) {
        classroom_mapper.updateClassroom(classroom);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.DELETE)
    public void deleteClassroom(String classroomId) {
        classroom_mapper.deleteClassroom(classroomId);
    }
}
