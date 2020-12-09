package com.example.zsgc.controller;

import com.example.zsgc.entity.Staff;
import com.example.zsgc.mapper.Staff_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
    public List<Staff> selectByStaffId(@RequestBody Staff staff) {
        return staff_mapper.selectByStaffId(staff);
    }

    @RequestMapping(value = {"/selectByIdOrName"}, method = RequestMethod.POST)
    public List<Staff> selectByIdOrName(@RequestBody Staff staff) {
        return staff_mapper.selectByIdOrName(staff);
    }

    @RequestMapping(value = {"/selectByGender"}, method = RequestMethod.POST)
    public List<Staff> selectByGender(@RequestBody Staff staff) {
        return staff_mapper.selectByGender(staff);
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertStaff(@RequestBody Staff staff) {
        staff_mapper.insertStaff(staff);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateStaff(@RequestBody Staff staff) {
        staff_mapper.updateStaff(staff);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.POST)
    public void deleteStaff(@RequestBody Staff staff) {
        staff_mapper.deleteStaff(staff);
    }
}
