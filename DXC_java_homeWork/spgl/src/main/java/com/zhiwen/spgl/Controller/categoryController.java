package com.zhiwen.spgl.Controller;

import com.zhiwen.spgl.DateBase.category;
import com.zhiwen.spgl.Response.Result;
import com.zhiwen.spgl.Service.Interface.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class categoryController {

    @Autowired
    private CategoryService categoryService;

     @GetMapping("/categories")
     public Result categoryList(){

         List<category> categoryList = categoryService.selectAllCategory();
         return Result.success(categoryList);
     }

     @PostMapping("/categories")
     public Result addCategory(@RequestBody category category){
         int result = categoryService.insertCategory(category);
         if(result == 0){
             return Result.error("添加失败");
         }
         return Result.success();
     }

      @GetMapping("/categories/{id}")
      public Result categoryDetail(@PathVariable Integer id){

          category category = categoryService.selectCategoryById(id);
          if(category == null){
              return Result.error("分类不存在");
          }
          return Result.success(category);
      }

      @PutMapping("/categories")
      public Result updateCategory(@RequestBody category category){
          int result = categoryService.updateCategory(category);
          if(result == 0){
              return Result.error("更新失败");
          }
          return Result.success();
      }

       @DeleteMapping("/categories")
       public Result deleteCategory(Integer id){
           int result = categoryService.deleteCategoryById(id);
           if(result == 0){
               return Result.error("删除失败");
           }
           return Result.success();
       }

}
