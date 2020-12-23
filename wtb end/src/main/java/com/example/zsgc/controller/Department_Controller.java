package com.example.zsgc.controller;

import com.example.zsgc.entity.Department;
import com.example.zsgc.entity.Query_age_cnt;
import com.example.zsgc.entity.Query_sex_count;
import com.example.zsgc.mapper.Department_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedList;
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

    @RequestMapping(value = {"/queryDepartmentAge"}, method = RequestMethod.POST)
    public int queryDepartmentAge(@RequestBody Department department, int age) {
        return department_mapper.queryDepartmentAge(department, age);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Query_age_cnt queryDepartmentAllAge(@RequestBody Department department) {
        int c18 = queryDepartmentAge(department,18);
        int c19 = queryDepartmentAge(department, 19);
        int c20 = queryDepartmentAge(department,20);
        int c21 = queryDepartmentAge(department, 21);
        int c22 = queryDepartmentAge(department, 22);
        return new Query_age_cnt(c18,c19,c20,c21,c22);
    }

    @RequestMapping(value = {"/queryDepartmentSex"}, method = RequestMethod.POST)
    public int queryDepartmentSex(@RequestBody Department department, String sex) {
        return department_mapper.queryDepartmentSex(department, sex);
    }

    @RequestMapping(method = RequestMethod.POST)
    public List<Query_age_cnt> queryAllDepartmentAge() {
        List<Query_age_cnt> list = new ArrayList<>();
        Department d1 = new Department("01","sb","sb");
        Department d2 = new Department("02","sb","sb");
        Department d3 = new Department("03","sb","sb");
        Department d4 = new Department("04","sb","sb");
        Department d5 = new Department("05","sb","sb");
        Department d6 = new Department("06","sb","sb");
        Department d73 = new Department("73","sb","sb");
        Query_age_cnt q1 = queryDepartmentAllAge(d1);
        Query_age_cnt q2 = queryDepartmentAllAge(d2);
        Query_age_cnt q3 = queryDepartmentAllAge(d3);
        Query_age_cnt q4 = queryDepartmentAllAge(d4);
        Query_age_cnt q5 = queryDepartmentAllAge(d5);
        Query_age_cnt q6 = queryDepartmentAllAge(d6);
        Query_age_cnt q73 = queryDepartmentAllAge(d73);
        list.add(q1);
        list.add(q2);
        list.add(q3);
        list.add(q4);
        list.add(q5);
        list.add(q6);
        list.add(q73);
        return list;
    }


    @RequestMapping(method = RequestMethod.POST)
    public Query_sex_count queryDepartmentAllSex(@RequestBody Department department) {
        int boyCnt = queryDepartmentSex(department,"男");
        int girlCnt = queryDepartmentSex(department, "女");
        return new Query_sex_count(boyCnt,girlCnt);
    }

    @RequestMapping(method = RequestMethod.POST)
    public List<Query_sex_count> queryAllDepartmentSex() {
        List<Query_sex_count> list = new ArrayList<>();
        Department d1 = new Department("01","sb","sb");
        Department d2 = new Department("02","sb","sb");
        Department d3 = new Department("03","sb","sb");
        Department d4 = new Department("04","sb","sb");
        Department d5 = new Department("05","sb","sb");
        Department d6 = new Department("06","sb","sb");
        Department d73 = new Department("73","sb","sb");
        Query_sex_count q1 = queryDepartmentAllSex(d1);
        Query_sex_count q2 = queryDepartmentAllSex(d2);
        Query_sex_count q3 = queryDepartmentAllSex(d3);
        Query_sex_count q4 = queryDepartmentAllSex(d4);
        Query_sex_count q5 = queryDepartmentAllSex(d5);
        Query_sex_count q6 = queryDepartmentAllSex(d6);
        Query_sex_count q73 = queryDepartmentAllSex(d73);
        list.add(q1);
        list.add(q2);
        list.add(q3);
        list.add(q4);
        list.add(q5);
        list.add(q6);
        list.add(q73);
        return list;
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
