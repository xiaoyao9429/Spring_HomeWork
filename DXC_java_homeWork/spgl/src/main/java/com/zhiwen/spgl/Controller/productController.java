package com.zhiwen.spgl.Controller;

import com.zhiwen.spgl.DateBase.product;
import com.zhiwen.spgl.Response.Result;

import com.zhiwen.spgl.Service.Interface.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RestController
public class productController {

    static final Logger log =  LoggerFactory.getLogger(productController.class);//日志记录器

    @Autowired
    private ProductService productService;


    @GetMapping(path = "/products")//获取所有商品
    public Result productList(@RequestParam(required = false) String name, @RequestParam(required = false) Integer category_id){
        log.info("获取所有商品,名称:{},分类id:{}",name,category_id);//记录日志
        List<product> products = productService.selectAllProduct(name, category_id);
        return Result.success(products);
    }


    @DeleteMapping(path = "/products")//根据id删除商品
    public Result deleteProduct(int id){
        log.info("根据id删除商品,id为:{}",id);//记录日志
        int result = productService.deleteProductById(id);
        if(result == 0){
            return Result.error("删除失败");
        }
        return Result.success();
    }


    @PostMapping(path = "/products")//添加商品
    public Result addProduct(@RequestBody product product){
        log.info("添加商品,商品信息为:{}",product);//记录日志
        int result = productService.insertProduct(product);
        if(result == 0){
            return Result.error("添加失败");
        }
        return Result.success();
    }

    @GetMapping(path = "/products/{id}")//根据id获取商品
    public Result getProductById(@PathVariable int id){
        log.info("根据id获取商品,id为:{}",id);//记录日志
        product product = productService.selectProductById(id);
        if(product == null){
            return Result.error("商品不存在");
        }
        return Result.success(product);
    }

    @PutMapping(path = "/products")//更新商品
    public Result updateProduct(@RequestBody product product){
        log.info("更新商品,商品信息为:{}",product);//记录日志
        int result = productService.updateProduct(product);
        if(result == 0){
            return Result.error("更新失败");
        }
        return Result.success();
    }

    @GetMapping(path = "/products/page/{n}")//分页查询商品，支持条件筛选
    public Result getProductByPage(@PathVariable int n, @RequestParam(required = false) String name, @RequestParam(required = false) Integer category_id){
        log.info("分页查询商品,第{}页,名称:{}，分类id:{}",n,name,category_id);//记录日志
        List<product> products = productService.selectByPage(n, name, category_id);
        return Result.success(products);
    }

    @GetMapping(path = "/products/number")//获取商品总数，支持条件筛选
    public Result getProductNumber(@RequestParam(required = false) String name, @RequestParam(required = false) Integer category_id){
        log.info("获取商品总数,名称:{},分类id:{}",name,category_id);//记录日志
        List<product> products = productService.selectAllProduct(name, category_id);
        return Result.success(products.size());
    }


    @GetMapping(path = "/products/category/{category_id}")//根据商品分类查询商品
    public Result getProductByCategory(@PathVariable int category_id){
        log.info("根据商品分类查询商品,分类id为:{}",category_id);//记录日志
        List<product> products = productService.selectByCategory(category_id);
        return Result.success(products);
    }

    @GetMapping(path = "/products/name/{name}")//根据商品名称查询商品
    public Result getProductByName(@PathVariable String name){
        log.info("根据商品名称查询商品,名称为:{}",name);//记录日志
        List<product> products = productService.selectByName(name);
        return Result.success(products);
    }
    
    @GetMapping(path = "/")//根路径跳转
    public RedirectView redirectToIndex(){
        log.info("根路径跳转");//记录日志
        return new RedirectView("/index.html");
    }


}