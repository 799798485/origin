package com.hr.product_producer.controller;

import com.hr.product_producer.pojo.Product;
import com.hr.product_producer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductService productService;

    //用get请求直接返回一个路径参数
    @GetMapping("/{pid}")
    public Product getProductById(@PathVariable Integer pid)
    {
        return productService.getProductById(pid);
    }
}