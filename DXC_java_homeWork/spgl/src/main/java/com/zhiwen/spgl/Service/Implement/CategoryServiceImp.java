package com.zhiwen.spgl.Service.Implement;

import com.zhiwen.spgl.DateBase.category;
import com.zhiwen.spgl.DateBase.categoryMapper;
import com.zhiwen.spgl.Service.Interface.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    private categoryMapper categoryMapper;

    @Override
    public List<category> selectAllCategory() {
        return categoryMapper.selectAll();
    }


    @Override
    public category selectCategoryById(Integer id) {
        return categoryMapper.selectById(id);
    }

    @Override
    public int insertCategory(category category) {
        return categoryMapper.insert(category);
    }

    @Override
    public int updateCategory(category category) {
        return categoryMapper.update(category);
    }

    @Override
    public int deleteCategoryById(Integer id) {
        return categoryMapper.deleteById(id);
    }
}
