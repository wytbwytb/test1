package com.example.zsgc.mapper;

import com.example.zsgc.entity.Class;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface Class_Mapper {
    @Select("select * from class") //管理员查看权限
    public List<Class> selectAll();
    //按照班级编号查询
    @Select("select * from class where 班级编号 like #{classId}") //管理员查看权限
    public List<Class> selectByClassId(Class aclass);

    //按照系编号查询
    @Select("select * from class where 系编号 = #{department}") //管理员查看权限
    public List<Class> selectByDepartment(Class aclass);

    //按照辅导员查询
    @Select("select * from class where 辅导员 = #{counsellor}") //管理员查看权限
    public List<Class> selectByCounsellor(Class aclass);

    @Insert("insert into class values (#{classId},#{department},#{header},#{counsellor})")
    public void insertClass(Class aclass);

    @Update("update class set 系编号=#{department}, 班主任=#{header}, 辅导员=#{counsellor} where 班级编号=#{classId}")
    public void updateClass(Class aclass);

    @Delete("delete from class where 班级编号=#{classId}")
    public void deleteClass(Class aclass);
}
