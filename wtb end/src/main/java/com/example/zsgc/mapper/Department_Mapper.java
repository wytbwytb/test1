package com.example.zsgc.mapper;

import com.example.zsgc.entity.Department;
import com.example.zsgc.entity.Query_sex_count;
import com.example.zsgc.entity.TestThing;
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
        "           and Student_Class.学生编号 = Student.学号 and Student.性别 = '男'\n" +
        "       )as ss")
    public int queryDepartmentSexBoy(Department department);

    @Select("select count(*) from (\n" +
        "       select Student_Class.学生编号 from Student_Class, Class, Student\n" +
        "           where Student_Class.班级 = Class.班级编号 and Class.系编号 = #{departmentId}\n" +
        "           and Student_Class.学生编号 = Student.学号 and Student.性别 = '女'\n" +
        "       )as ss")
    public int queryDepartmentSexGirl(Department department);

    @Select("select count(*) from (\n" +
        "       select Student_Class.学生编号 from Student_Class, Class, Student\n" +
        "           where Student_Class.班级 = Class.班级编号 and Class.系编号 = #{departmentId}\n" +
        "           and Student_Class.学生编号 = Student.学号 and Student.年龄 = 18\n" +
        "       )as ss")
    public int  queryDepartmentAge18(Department department);

    @Select("select count(*) from (\n" +
        "       select Student_Class.学生编号 from Student_Class, Class, Student\n" +
        "           where Student_Class.班级 = Class.班级编号 and Class.系编号 = #{departmentId}\n" +
        "           and Student_Class.学生编号 = Student.学号 and Student.年龄 = 19\n" +
        "       )as ss")
    public int  queryDepartmentAge19(Department department);

    @Select("select count(*) from (\n" +
        "       select Student_Class.学生编号 from Student_Class, Class, Student\n" +
        "           where Student_Class.班级 = Class.班级编号 and Class.系编号 = #{departmentId}\n" +
        "           and Student_Class.学生编号 = Student.学号 and Student.年龄 = 20\n" +
        "       )as ss")
    public int  queryDepartmentAge20(Department department);

    @Select("select count(*) from (\n" +
        "       select Student_Class.学生编号 from Student_Class, Class, Student\n" +
        "           where Student_Class.班级 = Class.班级编号 and Class.系编号 = #{departmentId}\n" +
        "           and Student_Class.学生编号 = Student.学号 and Student.年龄 = 21\n" +
        "       )as ss")
    public int  queryDepartmentAge21(Department department);

    @Select("select count(*) from (\n" +
        "       select Student_Class.学生编号 from Student_Class, Class, Student\n" +
        "           where Student_Class.班级 = Class.班级编号 and Class.系编号 = #{departmentId}\n" +
        "           and Student_Class.学生编号 = Student.学号 and Student.年龄 = 22\n" +
        "       )as ss")
    public int  queryDepartmentAge22(Department department);

    @Insert("insert into department values (#{departmentId},#{name},#{header})")
    public void insertDepartment(Department department);

    @Update("update department set 系名=#{name}, 系主任=#{header} where 系编号=#{departmentId}" )
    public void updateDepartment(Department department);

    @Delete("delete from department where 系编号=#{departmentId}")
    public void deleteDepartment(Department department);
}
