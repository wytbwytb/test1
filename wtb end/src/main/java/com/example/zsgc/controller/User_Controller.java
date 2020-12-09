package com.example.zsgc.controller;

import com.example.zsgc.entity.User;
import com.example.zsgc.mapper.User_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class User_Controller {
    @Autowired
    private User_Mapper user_mapper;

    @RequestMapping(value = {"/selectAll"}, method = RequestMethod.GET)
    public List<User> selectAll() {
        return user_mapper.selectAll();
    }

    @RequestMapping(value = {"/selectByUserName"}, method = RequestMethod.GET)
    public List<User> selectByUserName(@RequestBody User user) {
        return user_mapper.selectByUserName(user);
    }

    @RequestMapping(value = {"/selectByType"}, method = RequestMethod.GET)
    public List<User> selectByType(@RequestBody User user) {
        return user_mapper.selectByType(user);
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertUser(@RequestBody User user) {
        user_mapper.insertUser(user);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user) {
        user_mapper.updateUser(user);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.POST)
    public void deleteUser(@RequestBody User user) {
        user_mapper.deleteUser(user);
    }
}
