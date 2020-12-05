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

    //按照课程编号查询
    @Select("select * from course where 课程编号 like #{courseId} or 名称 like #{name}") //管理员查看权限
    public List<Course> selectByIdOrName(Course course);

    //按照课程名称查询
    @Select("select * from course where 名称 = #{name}") //管理员查看权限
    public List<Course> selectByName(Course course);

    //按照开设院系查询
    @Select("select * from course where 开设院系 = #{department}") //管理员查看权限
    public List<Course> selectByDepartment(Course course);

    @Insert("insert into course values (#{courseId},#{name},#{credit},#{department})")
    public void insertCourse(Course course);

    @Update("update course set 名称=#{name}, 学分=#{credit}, 开设院系=#{department} where 课程编号=#{courseId}")
    public void updateCourse(Course course);

    @Delete("delete from course where 课程编号=#{courseId}")
    public void deleteCourse(Course course);
}
