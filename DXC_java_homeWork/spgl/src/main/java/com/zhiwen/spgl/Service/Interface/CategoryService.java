package com.zhiwen.spgl.Service.Interface;

import com.zhiwen.spgl.DateBase.category;
import com.zhiwen.spgl.DateBase.product;
import com.zhiwen.spgl.Response.Result;

import java.util.List;

public interface CategoryService {

    List<category> selectAllCategory();
    category selectCategoryById(Integer id);
    int insertCategory(category category);
    int updateCategory(category category);
    int deleteCategoryById(Integer id);


}
