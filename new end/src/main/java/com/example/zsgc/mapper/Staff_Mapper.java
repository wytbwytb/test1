package com.example.zsgc.mapper;

import com.example.zsgc.entity.Staff;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface Staff_Mapper {
    @Select("select * from staff") //管理员查看权限
    public List<Staff> selectAll();

    //按照职工编号
    @Select("select * from staff where 职工编号 = #{staffId}") //管理员查看权限
    public List<Staff> selectByStaffId(Staff staff);

    //按照姓名
    @Select("select * from staff where 姓名 = #{name}") //管理员查看权限
    public List<Staff> selectByName(Staff staff);

    //按照性别
    @Select("select * from staff where 性别 = #{gender}") //管理员查看权限
    public List<Staff> selectByGender(Staff staff);

    @Insert("insert into staff values (#{staffId},#{name},#{gender},#{age},#{region},#{workAge})")
    public void insertStaff(Staff staff);

    @Update("update staff set 姓名=#{name}, 性别=#{gender}, 年龄=#{age}, 籍贯=#{region}, 工龄=#{workAge} where 职工编号=#{staffId}" )
    public void updateStaff(Staff staff);

    @Delete("delete from staff where 职工编号=#{staffId}")
    public void deleteStaff(String staffId);
}
