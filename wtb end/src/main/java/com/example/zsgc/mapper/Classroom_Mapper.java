package com.example.zsgc.mapper;

import com.example.zsgc.entity.Classroom;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface Classroom_Mapper {
    @Select("select * from classroom") //管理员查看权限
    public List<Classroom> selectAll();

    @Insert("insert into classroom values (#{classroomId},#{teachingBuilding},#{floors},#{type})")
    public void insertClassroom(Classroom classroom);

    @Update("update classroom set 教学楼名称=#{teachingBuilding}, 楼层=#{floors}, 类型=#{type} where 教师编号=#{classroomId}")
    public void updateClassroom(Classroom classroom);

    @Delete("delete from classroom where 教室编号=#{classroomId}")
    public void deleteClassroom(String classroomId);
}
