package com.example.zsgc.mapper;

import com.example.zsgc.entity.Association;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface Association_Mapper {
    @Select("select * from association") //管理员查看权限
    public List<Association> selectAll();

    @Select("select * from association where 名称 = #{name}") //按照社团名字查询
    public List<Association> selectByName(String name);

    @Insert("insert into association values (#{name},#{type},#{stars},#{teacher})")
    public void insertAssociation(Association association);

    @Update("update association set 类型=#{type},星级=#{stars},指导老师=#{teacher} where 名称=#{name}")
    public void updateAssociation(Association association);

    @Delete("delete from association where 名称=#{name}")
    public void deleteAssociation(String name);
}
