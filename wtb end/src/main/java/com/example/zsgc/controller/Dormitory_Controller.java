package com.example.zsgc.controller;

import com.example.zsgc.entity.Dormitory;
import com.example.zsgc.mapper.Dormitory_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertDormitory(Dormitory dormitory) {
        dormitory_mapper.insertDormitory(dormitory);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateDormitory(Dormitory dormitory) {
        dormitory_mapper.updateDormitory(dormitory);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.DELETE)
    public void deleteDormitory(String dormitoryId) {
        dormitory_mapper.deleteDormitory(dormitoryId);
    }
}
