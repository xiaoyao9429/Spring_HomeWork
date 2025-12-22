package com.zhiwen.spgl.Controller;

import com.zhiwen.spgl.DateBase.category;
import com.zhiwen.spgl.Response.Result;
import com.zhiwen.spgl.Service.Interface.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RestController
public class categoryController {
    static final Logger log =  LoggerFactory.getLogger(categoryController.class);//日志记录器

    @Autowired
    private CategoryService categoryService;

     @GetMapping("/categories")
     public Result categoryList(){
         log.info("获取所有分类");//记录日志
         List<category> categoryList = categoryService.selectAllCategory();
         return Result.success(categoryList);
     }

     @PostMapping("/categories")
     public Result addCategory(@RequestBody category category){
         log.info("添加分类,分类信息为:{}",category);//记录日志
         int result = categoryService.insertCategory(category);
         if(result == 0){
             return Result.error("添加失败");
         }
         return Result.success();
     }

      @GetMapping("/categories/{id}")
      public Result categoryDetail(@PathVariable Integer id){

         log.info("根据id获取分类,id为:{}",id);//记录日志
          category category = categoryService.selectCategoryById(id);
          if(category == null){
              return Result.error("分类不存在");
          }
          return Result.success(category);
      }

      @PutMapping("/categories")
      public Result updateCategory(@RequestBody category category){
         log.info("更新分类,分类信息为:{}",category);//记录日志
          int result = categoryService.updateCategory(category);
          if(result == 0){
              return Result.error("更新失败");
          }
          return Result.success();
      }

       @DeleteMapping("/categories")
       public Result deleteCategory(Integer id){
          log.info("根据id删除分类,id为:{}",id);//记录日志
           int result = categoryService.deleteCategoryById(id);
           if(result == 0){
               return Result.error("删除失败");
           }
           return Result.success();
       }

}
