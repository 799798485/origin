package com.hr.product_consumer.pojo;

import lombok.Data;

@Data
public class Product {
    private Integer pid;

    private String pname;

    private String description;

    private Double price;

    private Integer stock;

    private Integer cid;



    private String filename;

}