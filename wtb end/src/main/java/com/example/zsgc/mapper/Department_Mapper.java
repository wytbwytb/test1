package com.example.zsgc.mapper;

import com.example.zsgc.entity.Department;
import com.example.zsgc.entity.Query_sex_count;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface Department_Mapper {
    @Select("select * from department") //管理员查看权限
    public List<Department> selectAll();

    //按照系编号查询
    @Select("select * from department where 系编号 = #{departmentId} or 系名 = #{name}") //管理员查看权限
    public List<Department> selectByIdOrName(Department department);

    //按照系名查询
    @Select("select * from department where 系名 = #{name}") //管理员查看权限
    public List<Department> selectByName(Department department);

    @Select("select count(*) from (\n" +
            "       select Student_Class.学生编号 from Student_Class, Class, Student\n" +
            "           where Student_Class.班级 = Class.班级编号 and Class.系编号 = #{departmentId}\n" +
            "           and Student_Class.学生编号 = Student.学号 and Student.性别 = #{sex}\n" +
            "       )as ss")
    public int queryDepartmentSex(Department department, String sex);

    @Insert("insert into department values (#{departmentId},#{name},#{header})")
    public void insertDepartment(Department department);

    @Update("update department set 系名=#{name}, 系主任=#{header} where 系编号=#{departmentId}" )
    public void updateDepartment(Department department);

    @Delete("delete from department where 系编号=#{departmentId}")
    public void deleteDepartment(Department department);
}
