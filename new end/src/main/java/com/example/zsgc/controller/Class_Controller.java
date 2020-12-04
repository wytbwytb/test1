package com.example.zsgc.controller;

import com.example.zsgc.entity.Class;
import com.example.zsgc.mapper.Class_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/class")
public class Class_Controller {
    @Autowired
    private Class_Mapper class_mapper;

    @RequestMapping(value = {"/selectAll"}, method = RequestMethod.GET)
    public List<Class> selectAll() {
        return class_mapper.selectAll();
    }

    @RequestMapping(value = {"/selectByClassId"}, method = RequestMethod.POST)
    public List<Class> selectByClassId(Class aclass) {
        return class_mapper.selectByClassId(aclass);
    }

    @RequestMapping(value = {"/selectByDepartment"}, method = RequestMethod.POST)
    public List<Class> selectByDepartment(Class aclass) {
        return class_mapper.selectByDepartment(aclass);
    }

    @RequestMapping(value = {"/selectByCounsellor"}, method = RequestMethod.POST)
    public List<Class> selectByCounsellor(Class aclass) {
        return class_mapper.selectByCounsellor(aclass);
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertClass(Class aclass) {
        class_mapper.insertClass(aclass);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateBook(Class aclass) {
        class_mapper.updateClass(aclass);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.DELETE)
    public void deleteClass(String classId) {
        class_mapper.deleteClass(classId);
    }
}
