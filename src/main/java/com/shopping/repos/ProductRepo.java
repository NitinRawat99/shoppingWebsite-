package com.shopping.repos;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shopping.entities.Products;
import com.shopping.entities.User;

public interface ProductRepo extends MongoRepository<Products, BigInteger>{

}
