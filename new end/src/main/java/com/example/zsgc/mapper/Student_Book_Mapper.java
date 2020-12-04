package com.example.zsgc.mapper;

import com.example.zsgc.entity.Student_Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface Student_Book_Mapper {
    @Select("select * from student_book") //管理员查看权限
    public List<Student_Book> selectAll();

    @Select("select * from student_book where 学号 = #{student}") //管理员查看权限
    public List<Student_Book> selectByStudent(Student_Book student_book);

    @Select("select * from student_book where 图书编号 = #{book}") //管理员查看权限
    public List<Student_Book> selectByBook(Student_Book student_book);

    @Select("select * from student_book where 借阅时间 = #{borrowDate}") //管理员查看权限
    public List<Student_Book> selectByBorrowDate(Student_Book student_book);

    @Select("select * from student_book where 状态 = #{state}") //管理员查看权限
    public List<Student_Book> selectByState(Student_Book student_book);

    @Insert("insert into student_book values (#{student},#{book},#{borrowDate},#{state})")
    public void insertStudent_Book(Student_Book student_book);

    @Update("update student_book set 借阅时间=#{borrowDate}, 状态=#{state} where 学号=#{student} and 图书编号=#{book}" )
    public void updateStudent_Book(Student_Book student_book);

    @Delete("delete from student_book where 学号=#{student} and 图书编号=#{book}")
    public void deleteStudent_Book(Student_Book student_book);
}
