package com.example.zsgc.mapper;

import com.example.zsgc.entity.Query_Teacher_StudentGrade;
import com.example.zsgc.entity.Teacher;
import com.example.zsgc.entity.Teacher_Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface Teacher_Course_Mapper {
    @Select("select * from teacher_course") //管理员查看权限
    public List<Teacher_Course> selectAll();

    @Select("select * from teacher_course where 课程号 = #{course}") //管理员查看权限
    public List<Teacher_Course> selectByCourse(Teacher_Course teacher_course);

    @Select("select * from teacher_course where 教师编号 = #{teacher}") //管理员查看权限
    public List<Teacher_Course> selectByTeacher(Teacher_Course teacher_course);

    @Select("select * from teacher_course where 上课地点 = #{classroom}") //管理员查看权限
    public List<Teacher_Course> selectByClassroom(Teacher_Course teacher_course);

    @Select("select * from teacher_course where 上课时间 = #{time}") //管理员查看权限
    public List<Teacher_Course> selectByTime(Teacher_Course teacher_course);

    //查询该教师教的某个课程的所有学生成绩
    @Select("[Student-Course].学号, 姓名, 课程号, 成绩 from [Student-Course], Student" +
            "where [Student-Course].教师编号 = #{teacherId} and [Student-Course].课程号 = #{course} and Student.学号 = [Student-Course].学号" +
            "")
    public List<Query_Teacher_StudentGrade> queryCourseGrade(Teacher_Course teacher_course);

    //查询该教师教的所有课程的所有学生成绩
    @Select("[Student-Course].学号, 姓名, 课程号, 成绩 from [Student-Course], Student" +
            "where [Student-Course].教师编号 = #{teacherId} and Student.学号 = [Student-Course].学号" +
            "")
    public List<Query_Teacher_StudentGrade> queryAllGrade(Teacher_Course teacher_course);

    @Insert("insert into teacher_course values (#{course},#{teacher},#{classroom},#{time})")
    public void insertTeacher_Course(Teacher_Course teacher_course);

    @Update("update teacher_course set 上课地点=#{classroom}, 上课时间=#{time} where 课程号=#{course} and 教师编号=#{teacher}" )
    public void updateTeacher_Course(Teacher_Course teacher_course);

    @Delete("delete from teacher_course where 课程号=#{course} and 教师编号=#{teacher}")
    public void deleteTeacher_Course(Teacher_Course teacher_course);
}
