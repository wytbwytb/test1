package com.example.zsgc.mapper;

import com.example.zsgc.entity.Dormitory;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface Dormitory_Mapper {
    @Select("select * from dormitory") //管理员查看权限
    public List<Dormitory> selectAll();

    @Insert("insert into dormitory values (#{dormitoryId},#{dormitoryBuilding},#{floor},#{towards},#{header})")
    public void insertDormitory(Dormitory dormitory);

    @Update("update dormitory set 宿舍楼号=#{dormitoryBuilding}, 楼层=#{floor}, 朝向=#{towards}, 宿舍长=#{header} where 寝室号=#{dormitoryId}" )
    public void updateDormitory(Dormitory dormitory);

    @Delete("delete from dormitory where 寝室号=#{dormitoryId}")
    public void deleteDormitory(String dormitoryId);
}
