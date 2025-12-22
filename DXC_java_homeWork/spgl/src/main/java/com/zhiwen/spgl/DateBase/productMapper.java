package com.zhiwen.spgl.DateBase;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface productMapper {

    @Select("select * from product")
        List<product> selectAll();

    @Insert("insert into product( name, price, description, product_image, stock, category_id) values( #{name}, #{price}, #{description}, #{product_image}, #{stock}, #{category_id})")
    int insert(product product);

    @Select("select * from product where id = #{id}")
    product selectById(int id);

    @Update("update product set name=#{name}, price=#{price}, description=#{description}, product_image=#{product_image}, stock=#{stock}, category_id=#{category_id} where id=#{id}")
    int update(product product);

    @Delete("delete from product where id = #{id}")
    int delete(int id);

    //分页查询
    @Select("select * from product order by id limit ${(n - 1) * 8}, 8")//分页查询商品,每页8条
    List<product> selectByPage(int n);

    //根据商品分类查询商品
    @Select("select * from product where category_id = #{category_id}")
    List<product> selectByCategory(int category_id);

    //根据商品名称查询商品
    @Select("select * from product where name like #{name}")
    List<product> selectByName(String name);
}
