package com.example.zsgc.controller;

import com.example.zsgc.entity.Staff;
import com.example.zsgc.mapper.Staff_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class Staff_Controller {
    @Autowired
    private Staff_Mapper staff_mapper;

    @RequestMapping(value = {"/selectAll"}, method = RequestMethod.GET)
    public List<Staff> selectAll() {
        return staff_mapper.selectAll();
    }

    @RequestMapping(value = {"/selectByStaffId"}, method = RequestMethod.POST)
    public List<Staff> selectByStaffId(Staff staff) {
        return staff_mapper.selectByStaffId(staff);
    }

    @RequestMapping(value = {"/selectByName"}, method = RequestMethod.POST)
    public List<Staff> selectByName(Staff staff) {
        return staff_mapper.selectByName(staff);
    }

    @RequestMapping(value = {"/selectByGender"}, method = RequestMethod.POST)
    public List<Staff> selectByGender(Staff staff) {
        return staff_mapper.selectByGender(staff);
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertStaff(Staff staff) {
        staff_mapper.insertStaff(staff);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateStaff(Staff staff) {
        staff_mapper.updateStaff(staff);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.DELETE)
    public void deleteStaff(String staffId) {
        staff_mapper.deleteStaff(staffId);
    }
}
