package com.zhiwen.spgl.Controller;

import com.zhiwen.spgl.DateBase.product;
import com.zhiwen.spgl.Response.Result;

import com.zhiwen.spgl.Service.Interface.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class productController {

    @Autowired
    private ProductService productService;


    @GetMapping(path = "/products")//获取所有商品
    public Result productList(){
        List<product> products = productService.selectAllProduct();
        return Result.success(products);
    }


    @DeleteMapping(path = "/products")//根据id删除商品
    public Result deleteProduct(int id){
        int result = productService.deleteProductById(id);
        if(result == 0){
            return Result.error("删除失败");
        }
        return Result.success();
    }


    @PostMapping(path = "/products")//添加商品
    public Result addProduct(@RequestBody product product){
        int result = productService.insertProduct(product);
        if(result == 0){
            return Result.error("添加失败");
        }
        return Result.success();
    }

    @GetMapping(path = "/products/{id}")//根据id获取商品
    public Result getProductById(@PathVariable int id){
        product product = productService.selectProductById(id);
        if(product == null){
            return Result.error("商品不存在");
        }
        return Result.success(product);
    }

    @PutMapping(path = "/products")//更新商品
    public Result updateProduct(@RequestBody product product){
        int result = productService.updateProduct(product);
        if(result == 0){
            return Result.error("更新失败");
        }
        return Result.success();
    }
    
    @GetMapping(path = "/")//根路径跳转
    public RedirectView redirectToIndex(){
        return new RedirectView("/index.html");
    }


}
