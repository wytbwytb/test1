package com.example.zsgc.mapper;

import com.example.zsgc.entity.Student_Association;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface Student_Association_Mapper {
    @Select("select * from student_association") //管理员查看权限
    public List<Student_Association> selectAll();

    @Insert("insert into student_association values (#{student},#{association},#{position})")
    public void insertStudent_Association(Student_Association student_association);

    @Update("update student_association set 职位=#{position} where 学号=#{student} and 社团名称=#{association}" )
    public void updateStudent_Association(Student_Association student_association);

    @Delete("delete from student_association where 学号=#{student} and 社团名称=#{association}")
    public void deleteStudent_Association(Student_Association student_association);
}
