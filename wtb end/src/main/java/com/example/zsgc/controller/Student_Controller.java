package com.example.zsgc.controller;

import com.example.zsgc.entity.*;
import com.example.zsgc.mapper.Student_Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class Student_Controller {
    @Autowired
    private Student_Mapper student_mapper;

    @RequestMapping(value = {"/selectAll"}, method = RequestMethod.GET)
    public List<Student> selectAll() {
        return student_mapper.selectAll();
    }

    @RequestMapping(value = {"/selectByIdOrName"}, method = RequestMethod.POST)
    public List<Student> selectByStudentId(@RequestBody Student student) {
        return student_mapper.selectByIdOrName(student);
    }

    @RequestMapping(value = {"/selectByName"}, method = RequestMethod.POST)
    public List<Student> selectByName(@RequestBody Student student) {
        return student_mapper.selectByName(student);
    }

    @RequestMapping(value = {"/selectByGender"}, method = RequestMethod.POST)
    public List<Student> selectByGender(@RequestBody Student student) {
        return student_mapper.selectByGender(student);
    }

    @RequestMapping(value = {"/queryDormitory"}, method = RequestMethod.POST)
    public List<Query_Student_Dormitory> queryDormitory(@RequestBody Student student) {
        return student_mapper.queryDormitory(student);
    }

    @RequestMapping(value = {"/queryCourse"}, method = RequestMethod.POST)
    public List<Query_Student_Course> queryCourse(@RequestBody Student student) {
        return student_mapper.queryCourse(student);
    }

    @RequestMapping(value = {"/queryClass"}, method = RequestMethod.POST)
    public List<Query_Student_Class> queryClass(@RequestBody Student student) {
        return student_mapper.queryClass(student);
    }

    @RequestMapping(value = {"/queryBook"}, method = RequestMethod.POST)
    public List<Query_Student_Book> queryBook(@RequestBody Student student) {
        return student_mapper.queryBook(student);
    }

    @RequestMapping(value = {"/queryAssociation"}, method = RequestMethod.POST)
    public List<Query_Student_Association> queryAssociation(@RequestBody Student student) {
        return student_mapper.queryAssociation(student);
    }

    @RequestMapping(method = RequestMethod.POST)
    public List<Query_special> querySpecialMax(Student student){
        List<Query_special> list = new LinkedList<>();
        List<Student> students = student_mapper.selectAll();
        for (Student student2 : students) {
            //如果是自身，则跳过
            if (student2.getStudentId().equals(student.getStudentId())) {
                continue;
            }
            StudentDouble studentDouble = new StudentDouble(student.getStudentId(), student.getName(), student2.getStudentId(), student2.getName());
            list.add(querySpecial(studentDouble));
        }
        return list;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Query_special querySpecial(@RequestBody StudentDouble studentDouble){
        int same_course, same_course_teacher, same_association, same_dormitoryBuilding, same_dormitoryBuilding_place, same_book, same_class, same_department;
        same_course = student_mapper.querySameCourse(studentDouble);
        same_course_teacher = student_mapper.querySameCourseTeacher(studentDouble);
        same_association = student_mapper.querySameAssociation(studentDouble);
        same_dormitoryBuilding = student_mapper.querySameDormitoryBuilding(studentDouble);
        same_dormitoryBuilding_place = student_mapper.querySamePlace(studentDouble);
        same_book = student_mapper.querySameBook(studentDouble);
        same_class = student_mapper.querySameClass(studentDouble);
        same_department = student_mapper.querySameDepartment(studentDouble);
        return new Query_special(same_course,same_course_teacher,same_association,same_dormitoryBuilding,same_dormitoryBuilding_place,same_book,same_class,same_department);
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertStudent(@RequestBody Student student) {
        student_mapper.insertStudent(student);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateStudent(@RequestBody Student student) {
        student_mapper.updateStudent(student);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.POST)
    public void deleteStudent(@RequestBody Student student) {
        student_mapper.deleteStudent(student);
    }
}
