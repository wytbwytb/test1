package com.example.zsgc.mapper;

import com.example.zsgc.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface User_Mapper {
    @Select("select * from Userr") //管理员查看权限
    public List<User> selectAll();

    @Select("select * from Userr where 登录名 = #{userName}") //管理员查看权限
    public List<User> selectByUserName(User user);

    @Select("select * from Userr where 登录名 = #{userName} and 密码 = #{passwords}") //管理员查看权限
    public List<User> loginCheck(User user);

    @Select("select * from Userr where 类型 = #{type}") //管理员查看权限
    public List<User> selectByType(User user);

    @Insert("insert into Userr values (#{userName},#{passwords},#{type},#{id})")
    public void insertUser(User user);

    @Update("update Userr set 密码=#{passwords}, 类型=#{type}, 编号=#{id} where 登录名=#{userName}" )
    public void updateUser(User user);

    @Delete("delete from Userr where 登录名=#{userName}")
    public void deleteUser(User user);
}
