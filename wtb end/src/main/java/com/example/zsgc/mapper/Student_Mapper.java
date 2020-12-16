package com.example.zsgc.mapper;

import com.example.zsgc.entity.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface Student_Mapper {
    @Select("select * from student") //管理员查看权限
    public List<Student> selectAll();

    @Select("select * from student where 学号 like #{studentId} or 姓名 like #{name}")
    public List<Student> selectByIdOrName(Student student);

    @Select("select * from student where 姓名 = #{name}")
    public List<Student> selectByName(Student student);

    @Select("select * from student where 性别 = #{gender}")
    public List<Student> selectByGender(Student student);

    @Select("select 寝室号, 宿舍楼号, 所处区域, 楼层, 宿舍长, 朝向, 床位 from Dormitory, DormitoryBuilding, [Student-Dormitory]" +
            "where Dormitory.宿舍楼号 = DormitoryBuilding.楼号 and Dormitory.寝室号 = [Student-Dormitory].寝室 and [Student-Dormitory].学号 = #{studentId}")
    public List<Query_Student_Dormitory> queryDormitory(Student student);

    @Select("select 课程编号, 名称, 学分, 开设院系, Teacher.姓名 授课老师,上课地点, 上课时间, 成绩 from Course , [Student-Course], Teacher, [Teacher-Course]" +
            "where Course.课程编号 = [Student-Course].课程号 and  [Student-Course].学号 = #{studentId} and [Student-Course].教师编号 = Teacher.教师编号 and [Teacher-Course].教师编号 = Teacher.教师编号 and Course.课程编号 = [Teacher-Course].课程号")
    public List<Query_Student_Course> queryCourse(Student student);

    @Select("select  Department.系名 所在系, 系主任, 班级编号, Teacher.姓名 班主任, Student.姓名 辅导员, 职位 from Class, [Student-Class], Teacher, Student, Department" +
            "where Class.班级编号 = [Student-Class].班级 and [Student-Class].学生编号 = #{studentId} and Class.班主任 = Teacher.教师编号 and Class.辅导员 = Student.学号 and Department.系编号 = Class.系编号")
    public List<Query_Student_Class> queryClass(Student student);

    @Select("select Book.图书编号, 书名, 作者, 出版社, 出版年份, 借阅时间, 状态 from Book , [Student-Book]" +
            "where Book.图书编号 = [Student-Book].图书编号 and  [Student-Book].学号 = #{studentId}")
    public List<Query_Student_Book> queryBook(Student student);

    @Select("select 名称, 类型, 星级, 指导老师, 职位 from Association, [Student-Association]" +
            "where Association.名称 = [Student-Association].社团名称 and [Student-Association].学号 = #{studentId}")
    public List<Query_Student_Association> queryAssociation(Student student);

    @Select("select count(*) from" +
            "    (select 课程号 from Student_Course" +
            "    where 学号 = #{studentId1}" +
            "    intersect" +
            "    select 课程号 from Student_Course" +
            "    where 学号 = #{studentId2}) as Same_Course")
    public int querySameCourse(StudentDouble studentDouble);

    @Select("select count(*) from" +
            "    (select 课程号, 教师编号 from Student_Course" +
            "     where 学号 = #{studentId1}" +
            "     intersect" +
            "    select 课程号, 教师编号 from Student_Course" +
            "    where 学号 = #{studentId2}) as Same_Teacher")
    public int querySameCourseTeacher(StudentDouble studentDouble);

    @Select("select count(*) from" +
            "    (select 社团名称 from [Student-Association]" +
            "    where 学号 = #{studentId1}" +
            "    intersect" +
            "    select 社团名称 from [Student-Association]" +
            "    where 学号 = #{studentId2}'" +
            "        ) as Same_Asso")
    public int querySameAssociation(StudentDouble studentDouble);

    @Select("select count(*) from" +
            "    (select 宿舍楼号 from [Student-Dormitory], Dormitory" +
            "    where 学号 = #{studentId1} and [Student-Dormitory].寝室 = Dormitory.寝室号" +
            "    intersect" +
            "     select 宿舍楼号 from [Student-Dormitory], Dormitory" +
            "    where 学号 = #{studentId2} and [Student-Dormitory].寝室 = Dormitory.寝室号" +
            "    ) as Same_DB")
    public int querySameDormitoryBuilding(StudentDouble studentDouble);

    @Select("select count(*) from" +
            "    (select 所处区域 from [Student-Dormitory], Dormitory, DormitoryBuilding" +
            "     where 学号 = #{studentId1} and [Student-Dormitory].寝室 = Dormitory.寝室号 and Dormitory.宿舍楼号 = DormitoryBuilding.楼号" +
            "     intersect" +
            "     select 所处区域 from [Student-Dormitory], Dormitory, DormitoryBuilding" +
            "     where 学号 = #{studentId2} and [Student-Dormitory].寝室 = Dormitory.寝室号 and Dormitory.宿舍楼号 = DormitoryBuilding.楼号" +
            "    ) as Same_Place")
    public int querySamePlace(StudentDouble studentDouble);

    @Select("select count(*) from" +
            "    (select 图书编号 from Student_Book" +
            "        where 学号 = #{studentId1}" +
            "    intersect" +
            "     select 图书编号 from Student_Book" +
            "     where 学号 = #{studentId2}" +
            "        ) as Same_book")
    public int querySameBook(StudentDouble studentDouble);

    @Select("select count(*) from" +
            "    (select 班级 from Student_Class" +
            "        where 学生编号 = #{studentId1}" +
            "    intersect" +
            "     select 班级 from Student_Class" +
            "     where 学生编号 = #{studentId2}" +
            "        ) as Same_Class")
    public int querySameClass(StudentDouble studentDouble);

    @Select("select count(*) from" +
            "    (select 系编号 from Student_Class, Class" +
            "        where 学生编号 = #{studentId1} and Student_Class.班级 = Class.班级编号" +
            "    intersect" +
            "     select 系编号 from Student_Class, Class" +
            "     where 学生编号 = #{studentId2} and Student_Class.班级 = Class.班级编号" +
            "        )as Same_De")
    public int querySameDepartment(StudentDouble studentDouble);

    @Insert("insert into student values (#{studentId},#{name},#{gender},#{region},#{age})")
    public void insertStudent(Student student);

    @Update("update student set 姓名=#{name}, 性别=#{gender}, 籍贯=#{region}, 年龄=#{age} where 学号=#{studentId}" )
    public void updateStudent(Student student);

    @Delete("delete from student where 学号=#{studentId}")
    public void deleteStudent(Student student);
}
