package com.example.zsgc.mapper;

import com.example.zsgc.entity.Staff_DormitoryBuilding;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface Staff_DormitoryBuilding_Mapper {
    @Select("select * from staff_DormitoryBuilding") //管理员查看权限
    public List<Staff_DormitoryBuilding> selectAll();

    @Insert("insert into staff_DormitoryBuilding values (#{staff},#{dormitory})")
    public void insertStaff_DormitoryBuilding(Staff_DormitoryBuilding staff_DormitoryBuilding);

    @Update("update staff_DormitoryBuilding set 宿舍楼号=#{dormitory} where 职工编号=#{staff}" )//根据职工编号修改
    public void updateStaff_DormitoryBuilding(Staff_DormitoryBuilding staff_DormitoryBuilding);

    @Delete("delete from staff_DormitoryBuilding where 职工编号=#{staff} and 宿舍楼号=#{dormitory}")
    public void deleteStaff_DormitoryBuilding(Staff_DormitoryBuilding staff_DormitoryBuilding);
}
