package com.shopping.repos;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shopping.entities.User;

public interface Userrepo  extends MongoRepository<User, Integer>{

	@Query("{email:?0}")
	public User getUserByUserName(@Param("email") String email);
	
}
