package com.hr.product_consumer.client.impl;

import com.hr.product_consumer.client.ProductClient;
import org.springframework.stereotype.Component;


@Component
public class productClientFallback implements ProductClient {
    @Override
    public String getProductById(Integer pid) {
        return "服务器失踪了~~~";
    }
}
