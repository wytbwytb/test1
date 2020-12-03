package com.example.zsgc.controller;

import com.example.zsgc.entity.TeachingBuilding;
import com.example.zsgc.mapper.TeachingBuilding_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teachingbuilding")
public class TeachingBuilding_Controller {
    @Autowired
    private TeachingBuilding_Mapper teachingBuilding_mapper;

    @RequestMapping(value = {"/selectAll"}, method = RequestMethod.GET)
    public List<TeachingBuilding> selectAll() {
        return teachingBuilding_mapper.selectAll();
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertTeachingBuilding(TeachingBuilding teachingBuilding) {
        teachingBuilding_mapper.insertTeachingBuilding(teachingBuilding);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateTeachingBuilding(TeachingBuilding teachingBuilding) {
        teachingBuilding_mapper.updateTeachingBuilding(teachingBuilding);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.DELETE)
    public void deleteTeachingBuilding(String name) {
        teachingBuilding_mapper.deleteTeachingBuilding(name);
    }
}
