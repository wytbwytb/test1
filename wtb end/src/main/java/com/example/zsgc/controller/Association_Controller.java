package com.example.zsgc.controller;

import com.example.zsgc.entity.Association;
import com.example.zsgc.mapper.Association_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/association")
public class Association_Controller {
    @Autowired
    private Association_Mapper association_mapper;

    @RequestMapping(value = {"/selectAll"}, method = RequestMethod.GET)
    public List<Association> selectAll() {
        return association_mapper.selectAll();
    }

    @RequestMapping(value = {"/selectByName"}, method = RequestMethod.POST)
    public List<Association> selectByName(@RequestBody Association association) { return association_mapper.selectByName(association); }

    @RequestMapping(value = {"/selectByStudentId"}, method = RequestMethod.POST)
    public List<Association> selectByStudentId(@RequestBody Association association) { return association_mapper.selectByStudentId(association); }

    @RequestMapping(value = {"/selectByType"}, method = RequestMethod.POST)
    public List<Association> selectByType(@RequestBody Association association) { return association_mapper.selectByType(association); }

    @RequestMapping(value = {"/selectByStars"}, method = RequestMethod.POST)
    public List<Association> selectByStars(@RequestBody Association association) { return association_mapper.selectByStars(association); }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertAssociation(@RequestBody Association association) {
        association_mapper.insertAssociation(association);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateAssociation(@RequestBody Association association) {
        association_mapper.updateAssociation(association);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.POST)
    public void deleteAssociation(@RequestBody Association association) {
        association_mapper.deleteAssociation(association);
    }

}
