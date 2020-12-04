package com.example.zsgc.mapper;

import com.example.zsgc.entity.Student_Class;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface Student_Class_Mapper {
    @Select("select * from student_class") //管理员查看权限
    public List<Student_Class> selectAll();

    @Select("select * from student_class where 学生编号 = #{student}") //管理员查看权限
    public List<Student_Class> selectByStudent(Student_Class student_class);

    @Select("select * from student_class where 班级 = #{aclass}") //管理员查看权限
    public List<Student_Class> selectByAclass(Student_Class student_class);

    @Select("select * from student_class where 职位 = #{position}") //管理员查看权限
    public List<Student_Class> selectByPosition(Student_Class student_class);

    @Insert("insert into student_class values (#{student},#{aclass},#{position})")
    public void insertStudent_Class(Student_Class student_class);

    @Update("update student_class set 职位=#{position}, 班级=#{aclass} where 学生编号=#{student}" )
    public void updateStudent_Class(Student_Class student_class);

    @Delete("delete from student_class where 学生编号=#{student}")
    public void deleteStudent_Class(Student_Class student_class);
}
