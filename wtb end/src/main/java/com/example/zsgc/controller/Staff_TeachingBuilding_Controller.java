package com.example.zsgc.controller;

import com.example.zsgc.entity.Staff_TeachingBuilding;
import com.example.zsgc.mapper.Staff_TeachingBuilding_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertStaff_TeachingBuilding(Staff_TeachingBuilding staff_TeachingBuilding) {
        staff_TeachingBuilding_mapper.insertStaff_TeachingBuilding(staff_TeachingBuilding);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateStaff_TeachingBuilding(Staff_TeachingBuilding staff_TeachingBuilding) {
        staff_TeachingBuilding_mapper.updateStaff_TeachingBuilding(staff_TeachingBuilding);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.DELETE)
    public void deleteStaff_TeachingBuilding(Staff_TeachingBuilding staff_TeachingBuilding) {//传入一个类
        staff_TeachingBuilding_mapper.deleteStaff_TeachingBuilding(staff_TeachingBuilding);
    }
}
