package com.hr.product_producer.service.impl;

import com.hr.product_producer.dao.ProductMapper;
import com.hr.product_producer.pojo.Product;
import com.hr.product_producer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProudctServiceImpl implements ProductService {
    @Resource
    private ProductMapper productMapper;


    public Product getProductById(Integer pid) {
        return productMapper.selectByPrimaryKey(pid);
    }
}