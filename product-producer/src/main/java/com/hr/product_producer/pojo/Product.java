package com.hr.product_producer.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "product")
@Data
public class Product {
    @Id
    @KeySql(useGeneratedKeys = true)
	private Integer pid;

	private String pname;

	private String description;

	private Double price;

	private Integer stock;

	private Integer cid;



	private String filename;

}
