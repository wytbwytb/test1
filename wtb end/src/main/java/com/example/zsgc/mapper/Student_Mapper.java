package com.example.zsgc.mapper;

import com.example.zsgc.entity.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface Student_Mapper {
    @Select("select * from student") //管理员查看权限
    public List<Student> selectAll();

    @Insert("insert into student values (#{studentId},#{name},#{gender},#{region},#{age})")
    public void insertStudent(Student student);

    @Update("update student set 姓名=#{name}, 性别=#{gender}, 籍贯=#{region}, 年龄=#{age} where 学号=#{studentId}" )
    public void updateStudent(Student student);

    @Delete("delete from student where 学号=#{studentId}")
    public void deleteStudent(String studentId);
}
