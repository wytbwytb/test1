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

    @Insert("insert into book values (#{bookId},#{name},#{author},#{publisher},#{publishDate},#{state})")
    public void insertBook(Book book);

    @Update("update book set 书名=#{name}, 作者=#{author}, 出版社=#{publisher}, 出版年份=#{publishDate}, 借阅状态=#{state} where 图书编号=#{bookId}" )
    public void updateBook(Book book);

    @Delete("delete from book where 图书编号=#{bookId}")
    public void deleteBook(String bookId);
}
