package com.example.zsgc.controller;

import com.example.zsgc.entity.Book;
import com.example.zsgc.entity.TestThing;
import com.example.zsgc.mapper.Book_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Test_controller {
    @Autowired
    private Book_Mapper book_mapper;
    @CrossOrigin
    @PostMapping(value = "getbook")
    @ResponseBody
    public Book getbook(@RequestBody TestThing tt) {
        System.out.println("常规操作！");
        System.out.println(book_mapper.selectAll());
        System.out.println(book_mapper.selectAll().get(0));
        return book_mapper.selectAll().get(0);
    }
}
