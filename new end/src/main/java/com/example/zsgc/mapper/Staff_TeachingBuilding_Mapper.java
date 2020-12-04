package com.example.zsgc.mapper;

import com.example.zsgc.entity.Staff_TeachingBuilding;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface Staff_TeachingBuilding_Mapper {
    @Select("select * from staff_TeachingBuilding") //管理员查看权限
    public List<Staff_TeachingBuilding> selectAll();
    //按照职工编号
    @Select("select * from staff_TeachingBuilding where 职工编号 = #{staff}") //管理员查看权限
    public List<Staff_TeachingBuilding> selectByStaff(Staff_TeachingBuilding staff_TeachingBuilding);

    //按照教学楼名称
    @Select("select * from staff_TeachingBuilding where 教学楼名称 = #{teachingBuilding}") //管理员查看权限
    public List<Staff_TeachingBuilding> selectByTeachingBuilding(Staff_TeachingBuilding staff_TeachingBuilding);

    @Insert("insert into staff_TeachingBuilding values (#{staff},#{teachingBuilding})")
    public void insertStaff_TeachingBuilding(Staff_TeachingBuilding staff_TeachingBuilding);

    @Update("update staff_TeachingBuilding set 教学楼名称=#{teachingBuilding} where 职工编号=#{staff}" )//根据职工编号修改
    public void updateStaff_TeachingBuilding(Staff_TeachingBuilding staff_TeachingBuilding);

    @Delete("delete from staff_TeachingBuilding where 职工编号=#{staff} and 教学楼名称=#{teachingBuilding}")
    public void deleteStaff_TeachingBuilding(Staff_TeachingBuilding staff_TeachingBuilding);
}
