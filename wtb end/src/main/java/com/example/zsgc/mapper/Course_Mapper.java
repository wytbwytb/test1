package com.example.zsgc.mapper;

import com.example.zsgc.entity.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface Course_Mapper {
    @Select("select * from course") //管理员查看权限
    public List<Course> selectAll();

    @Insert("insert into course values (#{courseId},#{name},#{credit},#{department})")
    public void insertCourse(Course course);

    @Update("update course set 名称=#{name}, 学分=#{credit}, 开设院系=#{department} where 课程编号=#{courseId}")
    public void updateCourse(Course course);

    @Delete("delete from course where 课程编号=#{courseId}")
    public void deleteCourse(String courseId);
}
