package com.example.zsgc.mapper;

import com.example.zsgc.entity.Student_Dormitory;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface Student_Dormitory_Mapper {
    @Select("select * from student_dormitory") //管理员查看权限
    public List<Student_Dormitory> selectAll();

    @Insert("insert into student_dormitory values (#{student},#{dormitory},#{bedId})")
    public void insertStudent_Dormitory(Student_Dormitory student_dormitory);

    @Update("update student_dormitory set 寝室=#{dormitory}, 床位=#{bedId} where 学号=#{student}" )
    public void updateStudent_Dormitory(Student_Dormitory student_dormitory);

    @Delete("delete from student_dormitory where 学号=#{student}")
    public void deleteStudent_Dormitory(Student_Dormitory student_dormitory);
}
