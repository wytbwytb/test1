package com.example.zsgc.mapper;

import com.example.zsgc.entity.DormitoryBuilding;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DormitoryBuilding_Mapper {
    @Select("select * from dormitoryBuilding") //管理员查看权限
    public List<DormitoryBuilding> selectAll();

    //按照楼号查找
    @Select("select * from dormitoryBuilding where 楼号 = #{dormitoryBuildingId}") //管理员查看权限
    public List<DormitoryBuilding> selectByDormitoryBuildingId(DormitoryBuilding dormitoryBuilding);

    //按照类型查找
    @Select("select * from dormitoryBuilding where 类型 = #{type}") //管理员查看权限
    public List<DormitoryBuilding> selectByType(DormitoryBuilding dormitoryBuilding);

    //按照所处区域查找
    @Select("select * from dormitoryBuilding where 所处区域 = #{region}") //管理员查看权限
    public List<DormitoryBuilding> selectByRegion(DormitoryBuilding dormitoryBuilding);

    @Insert("insert into dormitoryBuilding values (#{dormitoryBuildingId},#{floors},#{size},#{type},#{region},#{buildDate})")
    public void insertDormitoryBuilding(DormitoryBuilding dormitoryBuilding);

    @Update("update dormitoryBuilding set 总楼层=#{floors}, 寝室容量=#{size}, 类型=#{type}, 所处区域=#{region}, 建设年份=#{buildDate} where 楼号=#{dormitoryBuildingId}" )
    public void updateDormitoryBuilding(DormitoryBuilding dormitoryBuilding);

    @Delete("delete from dormitoryBuilding where 楼号=#{dormitoryBuildingId}")
    public void deleteDormitoryBuilding(DormitoryBuilding dormitoryBuilding);
}
