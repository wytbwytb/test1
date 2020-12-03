package com.example.zsgc.mapper;

import com.example.zsgc.entity.Teacher_Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface Teacher_Course_Mapper {
    @Select("select * from teacher_course") //管理员查看权限
    public List<Teacher_Course> selectAll();

    @Insert("insert into teacher_course values (#{course},#{teacher},#{classroom},#{time})")
    public void insertTeacher_Course(Teacher_Course teacher_course);

    @Update("update teacher_course set 上课地点=#{classroom}, 上课时间=#{time} where 课程号=#{course} and 教师编号=#{teacher}" )
    public void updateTeacher_Course(Teacher_Course teacher_course);

    @Delete("delete from teacher_course where 课程号=#{course} and 教师编号=#{teacher}")
    public void deleteTeacher_Course(Teacher_Course teacher_course);
}
