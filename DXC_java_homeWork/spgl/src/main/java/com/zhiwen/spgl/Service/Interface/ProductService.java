package com.zhiwen.spgl.Service.Interface;

import com.zhiwen.spgl.DateBase.product;

import java.util.List;

public interface ProductService {
        List<product> selectAllProduct(String name, Integer category_id);//根据商品名称和分类id查询商品
        product selectProductById(Integer id);
        int insertProduct(product product);
        int updateProduct(product product);
        int deleteProductById(Integer id);
        List<product> selectByPage(int n, String name, Integer category_id);
        //根据商品分类查询商品
        List<product> selectByCategory(int category_id);
        //根据商品名称查询商品
        List<product> selectByName(String name);
}

