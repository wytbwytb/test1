package com.example.zsgc.mapper;

import com.example.zsgc.entity.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface Book_Mapper {
    @Select("select * from book") //管理员查看权限
    public List<Book> selectAll();
    //按照图书编号查询（查哪本书）
    @Select("select * from book where 图书编号 = #{bookId}") //管理员查看权限
    public List<Book> selectByBookId(Book book);
    //按名字查询
    @Select("select * from book where 书名 like N'%#{name}%'") //管理员查看权限
    public List<Book> selectByName(Book book);

    //按借阅状态查询
    @Select("select * from book where 借阅状态 = #{state}") //管理员查看权限
    public List<Book> selectByState(Book book);

    @Insert("insert into book values (#{bookId},#{name},#{author},#{publisher},#{publishDate},#{state})")
    public void insertBook(Book book);

    @Update("update book set 书名=#{name}, 作者=#{author}, 出版社=#{publisher}, 出版年份=#{publishDate}, 借阅状态=#{state} where 图书编号=#{bookId}" )
    public void updateBook(Book book);

    @Delete("delete from book where 图书编号=#{bookId}")
    public void deleteBook(String bookId);
}
