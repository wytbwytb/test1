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

    @Insert("insert into staff values (#{staffId},#{name},#{gender},#{age},#{region},#{workAge})")
    public void insertStaff(Staff staff);

    @Update("update staff set 姓名=#{name}, 性别=#{gender}, 年龄=#{age}, 籍贯=#{region}, 工龄=#{workAge} where 职工编号=#{staffId}" )
    public void updateStaff(Staff staff);

    @Delete("delete from staff where 职工编号=#{staffId}")
    public void deleteStaff(String staffId);
}
