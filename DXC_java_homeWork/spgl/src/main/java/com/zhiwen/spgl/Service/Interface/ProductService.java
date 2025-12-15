package com.zhiwen.spgl.Service.Interface;

import com.zhiwen.spgl.DateBase.product;

import java.util.List;

public interface ProductService {
        List<product> selectAllProduct();
        product selectProductById(Integer id);
        int insertProduct(product product);
        int updateProduct(product product);
        int deleteProductById(Integer id);

}
