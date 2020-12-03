package com.example.zsgc.mapper;

import com.example.zsgc.entity.Teacher;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface Teacher_Mapper {
    @Select("select * from teacher") //管理员查看权限
    public List<Teacher> selectAll();

    @Insert("insert into teacher values (#{teacherId},#{name},#{gender},#{age},#{region},#{email},#{teachingAge},#{department},#{title})")
    public void insertTeacher(Teacher teacher);

    @Update("update teacher set 姓名=#{name}, 性别=#{gender}, 年龄=#{age}, 籍贯=#{region}, 邮箱=#{email}, 教龄=#{teachingAge}, 院系=#{department}, 职称=#{title} where 教师编号=#{teacherId}" )
    public void updateTeacher(Teacher teacher);

    @Delete("delete from teacher where 教师编号=#{teacherId}")
    public void deleteTeacher(String teacherId);
}
