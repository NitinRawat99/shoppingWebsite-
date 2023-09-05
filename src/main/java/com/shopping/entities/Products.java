package com.shopping.entities;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="products")
public class Products {
	
	@Id
	private BigInteger sno;
	private String product_name;
	private int price;
	private String size;
	public Products(BigInteger sno, String product_name, int price, String size) {
		super();
		this.sno = sno;
		this.product_name = product_name;
		this.price = price;
		this.size = size;
	}
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BigInteger getSno() {
		return sno;
	}
	public void setSno(BigInteger sno) {
		this.sno = sno;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
	
	
	

}
