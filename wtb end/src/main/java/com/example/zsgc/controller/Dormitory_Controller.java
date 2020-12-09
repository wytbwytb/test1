package com.example.zsgc.controller;

import com.example.zsgc.entity.Dormitory;
import com.example.zsgc.mapper.Dormitory_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dormitory")
public class Dormitory_Controller {
    @Autowired
    private Dormitory_Mapper dormitory_mapper;

    @RequestMapping(value = {"/selectAll"}, method = RequestMethod.GET)
    public List<Dormitory> selectAll() {
        return dormitory_mapper.selectAll();
    }

    @RequestMapping(value = {"/selectByDormitoryId"}, method = RequestMethod.POST)
    public List<Dormitory> selectByDormitoryId(@RequestBody Dormitory dormitory) {
        return dormitory_mapper.selectByDormitoryId(dormitory);
    }

    @RequestMapping(value = {"/selectByDormitoryBuilding"}, method = RequestMethod.POST)
    public List<Dormitory> selectByDormitoryBuilding(@RequestBody Dormitory dormitory) {
        return dormitory_mapper.selectByDormitoryBuilding(dormitory);
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertDormitory(@RequestBody Dormitory dormitory) {
        dormitory_mapper.insertDormitory(dormitory);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateDormitory(@RequestBody Dormitory dormitory) {
        dormitory_mapper.updateDormitory(dormitory);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.POST)
    public void deleteDormitory(@RequestBody Dormitory dormitory) {
        dormitory_mapper.deleteDormitory(dormitory);
    }
}
