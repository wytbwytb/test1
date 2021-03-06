package com.example.zsgc.mapper;

import com.example.zsgc.entity.Student_Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface Student_Course_Mapper {
    @Select("select * from student_course") //管理员查看权限
    public List<Student_Course> selectAll();

    @Select("select 名称,课程号,教师编号,成绩 from student_course,course where student_course.学号 = #{student} and student_course.课程号 = course.课程编号") //管理员查看权限
    public List<Student_Course> selectByStudent(Student_Course student_course);

    @Select("select * from student_course where 课程号 = #{course}") //管理员查看权限
    public List<Student_Course> selectByCourse(Student_Course student_course);

    @Insert("insert into student_course values (#{student},#{course},#{teacher},#{grade})")
    public void insertStudent_Course(Student_Course student_course);

    @Update("update student_course set 教师编号=#{teacher}, 成绩=#{grade} where 学号=#{student} and 课程号=#{course}" )
    public void updateStudent_Course(Student_Course student_course);

    @Delete("delete from student_course where 学号=#{student} and 课程号=#{course}")
    public void deleteStudent_Course(Student_Course student_course);
}
