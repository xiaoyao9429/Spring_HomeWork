package com.zhiwen.spgl.Controller;

import com.zhiwen.spgl.DateBase.product;
import com.zhiwen.spgl.Response.Result;

import com.zhiwen.spgl.Service.Interface.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class productController {

    @Autowired
    private ProductService productService;


    @GetMapping(path = "/products")
    public Result product(){
        List<product> products = productService.selectAllProduct();
        return Result.success(products);
    }
}
