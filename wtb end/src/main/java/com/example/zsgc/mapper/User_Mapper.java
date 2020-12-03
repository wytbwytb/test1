package com.example.zsgc.mapper;

import com.example.zsgc.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface User_Mapper {
    @Select("select * from user") //管理员查看权限
    public List<User> selectAll();

    @Insert("insert into user values (#{userName},#{passwords},#{type},#{id})")
    public void insertUser(User user);

    @Update("update user set 密码=#{passwords}, 类型=#{type}, 编号=#{id} where 登录名=#{userName}" )
    public void updateUser(User user);

    @Delete("delete from user where 登录名=#{userName}")
    public void deleteUser(String userName);
}
