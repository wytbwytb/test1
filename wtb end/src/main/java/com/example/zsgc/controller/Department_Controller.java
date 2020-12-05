package com.example.zsgc.controller;

import com.example.zsgc.entity.Department;
import com.example.zsgc.mapper.Department_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/department")
public class Department_Controller {
    @Autowired
    private Department_Mapper department_mapper;

    @RequestMapping(value = {"/selectAll"}, method = RequestMethod.GET)
    public List<Department> selectAll() {
        return department_mapper.selectAll();
    }

    @RequestMapping(value = {"/selectByIdOrName"}, method = RequestMethod.POST)
    public List<Department> selectByIdOrName(@RequestBody Department department) {
        return department_mapper.selectByIdOrName(department);
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertDepartment(@RequestBody Department department) {
        department_mapper.insertDepartment(department);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateDepartment(@RequestBody Department department) {
        department_mapper.updateDepartment(department);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.POST)
    public void deleteDepartment(@RequestBody Department department) {
        department_mapper.deleteDepartment(department);
    }
}
