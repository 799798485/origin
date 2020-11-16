package com.hr.product_consumer.client;

import com.hr.product_consumer.client.impl.productClientFallback;
import com.hr.product_consumer.pojo.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;


//需要手动找到fallback实现类
@FeignClient(value = "PRODUCT-PRODUCER",fallback = productClientFallback.class)
public interface ProductClient {



    //用get请求直接返回一个路径参数
    //自动去扫描id，自动扫描你的请求路径

    @GetMapping("product/{pid}")
    public String getProductById(@PathVariable Integer pid);

    //其实最终还是转换成了这样
    //String url = "http://PRODUCT-PRODUCER/product/" + pid;
//        String product = restTemplate.getForObject(url, String.class);

}