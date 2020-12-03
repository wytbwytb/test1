package com.example.zsgc.controller;

import com.example.zsgc.entity.User;
import com.example.zsgc.mapper.User_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertUser(User user) {
        user_mapper.insertUser(user);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateUser(User user) {
        user_mapper.updateUser(user);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.DELETE)
    public void deleteUser(String userName) {
        user_mapper.deleteUser(userName);
    }
}
