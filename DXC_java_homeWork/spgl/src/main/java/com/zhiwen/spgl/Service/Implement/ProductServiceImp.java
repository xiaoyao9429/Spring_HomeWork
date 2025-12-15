package com.zhiwen.spgl.Service.Implement;

import com.zhiwen.spgl.DateBase.product;
import com.zhiwen.spgl.Service.Interface.ProductService;

import com.zhiwen.spgl.DateBase.productMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private productMapper productMapper;

    @Override
    public List<product> selectAllProduct() {
        return productMapper.selectAll();
    }

    @Override
    public product selectProductById(Integer id) {

        return productMapper.selectById(id);
    }

    @Override
    public int insertProduct(product product) {
        return productMapper.insert(product);
    }

    @Override
    public int updateProduct(product product) {
        return productMapper.update(product);
    }

    @Override
    public int deleteProductById(Integer id) {
        return productMapper.delete(id);
    }
}
