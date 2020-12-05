package com.example.zsgc.controller;

import com.example.zsgc.entity.Classroom;
import com.example.zsgc.mapper.Classroom_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping(value = {"/selectByClassroomId"}, method = RequestMethod.POST)
    public List<Classroom> selectByClassroomId(@RequestBody Classroom classroom) {
        return classroom_mapper.selectByClassroomId(classroom);
    }

    @RequestMapping(value = {"/selectByTeachingBuilding"}, method = RequestMethod.POST)
    public List<Classroom> selectByTeachingBuilding(@RequestBody Classroom classroom) {
        return classroom_mapper.selectByTeachingBuilding(classroom);
    }

    @RequestMapping(value = {"/selectByType"}, method = RequestMethod.POST)
    public List<Classroom> selectByType(@RequestBody Classroom classroom) {
        return classroom_mapper.selectByType(classroom);
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertClassroom(@RequestBody Classroom classroom) {
        classroom_mapper.insertClassroom(classroom);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateClassroom(@RequestBody Classroom classroom) {
        classroom_mapper.updateClassroom(classroom);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.POST)
    public void deleteClassroom(@RequestBody Classroom classroom) {
        classroom_mapper.deleteClassroom(classroom);
    }
}
