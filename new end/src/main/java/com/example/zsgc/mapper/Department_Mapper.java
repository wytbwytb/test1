package com.example.zsgc.mapper;

import com.example.zsgc.entity.Department;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface Department_Mapper {
    @Select("select * from department") //管理员查看权限
    public List<Department> selectAll();

    //按照系编号查询
    @Select("select * from department where 系编号 = #{departmentId}") //管理员查看权限
    public List<Department> selectByDepartmentId(Department department);

    //按照系名查询
    @Select("select * from department where 系名 = #{name}") //管理员查看权限
    public List<Department> selectByName(Department department);

    @Insert("insert into department values (#{departmentId},#{name},#{header})")
    public void insertDepartment(Department department);

    @Update("update department set 系名=#{name}, 系主任=#{header} where 系编号=#{departmentId}" )
    public void updateDepartment(Department department);

    @Delete("delete from department where 系编号=#{departmentId}")
    public void deleteDepartment(String departmentId);
}
