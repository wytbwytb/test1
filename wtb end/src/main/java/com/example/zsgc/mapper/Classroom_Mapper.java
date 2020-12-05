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

    //按照教室编号查询
    @Select("select * from classroom where 教室编号 like #{classroomId}") //管理员查看权限
    public List<Classroom> selectByClassroomId(Classroom classroom);

    //按照教学楼查询
    @Select("select * from classroom where 教学楼名称 =  #{teachingBuilding}") //管理员查看权限
    public List<Classroom> selectByTeachingBuilding(Classroom classroom);

    //按照类型查询
    @Select("select * from classroom where 类型 =  #{type}") //管理员查看权限
    public List<Classroom> selectByType(Classroom classroom);


    @Insert("insert into classroom values (#{classroomId},#{teachingBuilding},#{floors},#{type})")
    public void insertClassroom(Classroom classroom);

    @Update("update classroom set 教学楼名称=#{teachingBuilding}, 楼层=#{floors}, 类型=#{type} where 教室编号=#{classroomId}")
    public void updateClassroom(Classroom classroom);

    @Delete("delete from classroom where 教室编号=#{classroomId}")
    public void deleteClassroom(Classroom classroom);
}
