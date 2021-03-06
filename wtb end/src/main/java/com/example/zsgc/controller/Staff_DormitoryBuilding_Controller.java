package com.example.zsgc.controller;

import com.example.zsgc.entity.Staff_DormitoryBuilding;
import com.example.zsgc.mapper.Staff_DormitoryBuilding_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/staffdormitorybuilding")
public class Staff_DormitoryBuilding_Controller {
    @Autowired
    private Staff_DormitoryBuilding_Mapper staff_DormitoryBuilding_mapper;

    @RequestMapping(value = {"/selectAll"}, method = RequestMethod.GET)
    public List<Staff_DormitoryBuilding> selectAll() {
        return staff_DormitoryBuilding_mapper.selectAll();
    }

    @RequestMapping(value = {"/selectByStaff"}, method = RequestMethod.POST)
    public List<Staff_DormitoryBuilding> selectByStaff(@RequestBody Staff_DormitoryBuilding staff_DormitoryBuilding) {
        return staff_DormitoryBuilding_mapper.selectByStaff(staff_DormitoryBuilding);
    }

    @RequestMapping(value = {"/selectByDormitory"}, method = RequestMethod.POST)
    public List<Staff_DormitoryBuilding> selectByDormitory(@RequestBody Staff_DormitoryBuilding staff_DormitoryBuilding) {
        return staff_DormitoryBuilding_mapper.selectByDormitory(staff_DormitoryBuilding);
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertStaff_DormitoryBuilding(@RequestBody Staff_DormitoryBuilding staff_DormitoryBuilding) {
        staff_DormitoryBuilding_mapper.insertStaff_DormitoryBuilding(staff_DormitoryBuilding);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateStaff_DormitoryBuilding(@RequestBody Staff_DormitoryBuilding staff_DormitoryBuilding) {
        staff_DormitoryBuilding_mapper.updateStaff_DormitoryBuilding(staff_DormitoryBuilding);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.POST)
    public void deleteStaff_DormitoryBuilding(@RequestBody Staff_DormitoryBuilding staff_DormitoryBuilding) {//传入一个类
        staff_DormitoryBuilding_mapper.deleteStaff_DormitoryBuilding(staff_DormitoryBuilding);
    }
}
