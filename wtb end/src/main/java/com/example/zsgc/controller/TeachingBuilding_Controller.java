package com.example.zsgc.controller;

import com.example.zsgc.entity.TeachingBuilding;
import com.example.zsgc.mapper.TeachingBuilding_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping(value = {"/selectByName"}, method = RequestMethod.POST)
    public List<TeachingBuilding> selectByName(@RequestBody TeachingBuilding teachingBuilding) {
        return teachingBuilding_mapper.selectByName(teachingBuilding);
    }

    @RequestMapping(value = {"/selectByRegion"}, method = RequestMethod.POST)
    public List<TeachingBuilding> selectByRegion(@RequestBody TeachingBuilding teachingBuilding) {
        return teachingBuilding_mapper.selectByRegion(teachingBuilding);
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertTeachingBuilding(@RequestBody TeachingBuilding teachingBuilding) {
        teachingBuilding_mapper.insertTeachingBuilding(teachingBuilding);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateTeachingBuilding(@RequestBody TeachingBuilding teachingBuilding) {
        teachingBuilding_mapper.updateTeachingBuilding(teachingBuilding);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.POST)
    public void deleteTeachingBuilding(@RequestBody TeachingBuilding teachingBuilding) {
        teachingBuilding_mapper.deleteTeachingBuilding(teachingBuilding);
    }
}
