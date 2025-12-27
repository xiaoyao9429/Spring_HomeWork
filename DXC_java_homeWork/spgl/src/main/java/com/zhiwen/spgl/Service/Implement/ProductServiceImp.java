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
    public List<product> selectAllProduct(String name, Integer category_id) {
        // 如果没有条件，直接调用selectAll
        if (name == null && category_id == null) {
            return productMapper.selectAll();
        }
        // 如果有条件，需要构建查询条件
        // 这里可以调用新的mapper方法，或者在service层过滤
        // 为了简化，先使用这种方式，后面再优化
        List<product> allProducts = productMapper.selectAll();
        return allProducts.stream()
                .filter(p -> (name == null || p.getName().contains(name)))
                .filter(p -> (category_id == null || p.getCategory_id().equals(category_id)))
                .collect(java.util.stream.Collectors.toList());
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

    @Override
    public List<product> selectByPage(int n, String name, Integer category_id) {
        // 如果没有条件，直接调用原来的selectByPage
        if (name == null && category_id == null) {
            return productMapper.selectByPage(n);
        }
        // 如果有条件，先获取所有符合条件的商品，然后在service层进行分页
        // 这种方式效率不高，但为了快速实现功能，先这样做
        List<product> allProducts = selectAllProduct(name, category_id);
        int startIndex = (n - 1) * 8;
        int endIndex = Math.min(startIndex + 8, allProducts.size());
        if (startIndex >= allProducts.size()) {
            return new java.util.ArrayList<>();
        }
        return allProducts.subList(startIndex, endIndex);
    }

    @Override
    public List<product> selectByCategory(int category_id) {
        return productMapper.selectByCategory(category_id);
    }

    @Override
    public List<product> selectByName(String name) {
        return productMapper.selectByName("%" + name + "%");
    }
}

