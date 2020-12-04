package com.example.zsgc.controller;

import com.example.zsgc.entity.DormitoryBuilding;
import com.example.zsgc.mapper.DormitoryBuilding_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dormitorybuilding")
public class DormitoryBuilding_Controller {
    @Autowired
    private DormitoryBuilding_Mapper dormitoryBuilding_mapper;

    @RequestMapping(value = {"/selectAll"}, method = RequestMethod.GET)
    public List<DormitoryBuilding> selectAll() {
        return dormitoryBuilding_mapper.selectAll();
    }

    @RequestMapping(value = {"/selectByDormitoryBuildingId"}, method = RequestMethod.POST)
    public List<DormitoryBuilding> selectByDormitoryBuildingId(DormitoryBuilding dormitoryBuilding) {
        return dormitoryBuilding_mapper.selectByDormitoryBuildingId(dormitoryBuilding);
    }

    @RequestMapping(value = {"/selectByType"}, method = RequestMethod.POST)
    public List<DormitoryBuilding> selectByType(DormitoryBuilding dormitoryBuilding) {
        return dormitoryBuilding_mapper.selectByType(dormitoryBuilding);
    }

    @RequestMapping(value = {"/selectByRegion"}, method = RequestMethod.POST)
    public List<DormitoryBuilding> selectByRegion(DormitoryBuilding dormitoryBuilding) {
        return dormitoryBuilding_mapper.selectByRegion(dormitoryBuilding);
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertDormitoryBuilding(DormitoryBuilding dormitoryBuilding) {
        dormitoryBuilding_mapper.insertDormitoryBuilding(dormitoryBuilding);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateDormitoryBuilding(DormitoryBuilding dormitoryBuilding) {
        dormitoryBuilding_mapper.updateDormitoryBuilding(dormitoryBuilding);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.DELETE)
    public void deleteDormitoryBuilding(String dormitoryBuildingId) {
        dormitoryBuilding_mapper.deleteDormitoryBuilding(dormitoryBuildingId);
    }
}
