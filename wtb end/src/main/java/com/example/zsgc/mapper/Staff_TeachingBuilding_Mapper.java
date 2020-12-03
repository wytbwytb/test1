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

    @Insert("insert into staff_TeachingBuilding values (#{staff},#{teachingBuilding})")
    public void insertStaff_TeachingBuilding(Staff_TeachingBuilding staff_TeachingBuilding);

    @Update("update staff_TeachingBuilding set 教学楼名称=#{teachingBuilding} where 职工编号=#{staff}" )//根据职工编号修改
    public void updateStaff_TeachingBuilding(Staff_TeachingBuilding staff_TeachingBuilding);

    @Delete("delete from staff_TeachingBuilding where 职工编号=#{staff} and 教学楼名称=#{teachingBuilding}")
    public void deleteStaff_TeachingBuilding(Staff_TeachingBuilding staff_TeachingBuilding);
}
