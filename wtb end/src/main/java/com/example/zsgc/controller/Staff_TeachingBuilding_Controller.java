package com.example.zsgc.controller;

import com.example.zsgc.entity.Staff_TeachingBuilding;
import com.example.zsgc.mapper.Staff_TeachingBuilding_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/staffteachingbuilding")
public class Staff_TeachingBuilding_Controller {
    @Autowired
    private Staff_TeachingBuilding_Mapper staff_TeachingBuilding_mapper;

    @RequestMapping(value = {"/selectAll"}, method = RequestMethod.GET)
    public List<Staff_TeachingBuilding> selectAll() {
        return staff_TeachingBuilding_mapper.selectAll();
    }

    @RequestMapping(value = {"/selectByStaff"}, method = RequestMethod.POST)
    public List<Staff_TeachingBuilding> selectByStaff(@RequestBody Staff_TeachingBuilding staff_TeachingBuilding) {
        return staff_TeachingBuilding_mapper.selectByStaff(staff_TeachingBuilding);
    }

    @RequestMapping(value = {"/selectByTeachingBuilding"}, method = RequestMethod.POST)
    public List<Staff_TeachingBuilding> selectByTeachingBuilding(@RequestBody Staff_TeachingBuilding staff_TeachingBuilding) {
        return staff_TeachingBuilding_mapper.selectByTeachingBuilding(staff_TeachingBuilding);
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertStaff_TeachingBuilding(@RequestBody Staff_TeachingBuilding staff_TeachingBuilding) {
        staff_TeachingBuilding_mapper.insertStaff_TeachingBuilding(staff_TeachingBuilding);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateStaff_TeachingBuilding(@RequestBody Staff_TeachingBuilding staff_TeachingBuilding) {
        staff_TeachingBuilding_mapper.updateStaff_TeachingBuilding(staff_TeachingBuilding);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.POST)
    public void deleteStaff_TeachingBuilding(@RequestBody Staff_TeachingBuilding staff_TeachingBuilding) {//传入一个类
        staff_TeachingBuilding_mapper.deleteStaff_TeachingBuilding(staff_TeachingBuilding);
    }
}
