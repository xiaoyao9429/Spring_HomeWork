package com.zhiwen.spgl.DateBase;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface categoryMapper {

    @Select("select * from category where id = #{id}")
    category selectById(Integer id);

    @Select("select * from category")
    List<category> selectAll();

    @Delete("delete from category where id = #{id}")
    int deleteById(Integer id);

    @Insert("insert into category(category_name, category_desc) values(#{category_name}, #{category_desc})")
    int insert(category category);

     @Update("update category set category_name = #{category_name}, category_desc = #{category_desc} where id = #{id}")
    int update(category category);

}
