package com.example.zsgc.mapper;

import com.example.zsgc.entity.TeachingBuilding;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TeachingBuilding_Mapper {
    @Select("select * from teachingBuilding") //管理员查看权限
    public List<TeachingBuilding> selectAll();

    @Select("select * from teachingBuilding where 名称 = #{name}") //管理员查看权限
    public List<TeachingBuilding> selectByName(TeachingBuilding teachingBuilding);

    @Select("select * from teachingBuilding where 所处年份 = #{region}") //管理员查看权限
    public List<TeachingBuilding> selectByRegion(TeachingBuilding teachingBuilding);

    @Insert("insert into teachingBuilding values (#{name},#{region},#{floors},#{buildDate})")
    public void insertTeachingBuilding(TeachingBuilding teachingBuilding);

    @Update("update teachingBuilding set 所处区域=#{region}, 总楼层=#{floors}, 建设年份=#{buildDate} where 名称=#{name}" )
    public void updateTeachingBuilding(TeachingBuilding teachingBuilding);

    @Delete("delete from teachingBuilding where 名称=#{name}")
    public void deleteTeachingBuilding(String name);
}
