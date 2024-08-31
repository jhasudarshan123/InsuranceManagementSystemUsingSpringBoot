package com.javatpoint.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javatpoint.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	Optional<User> findOneByEmailAndPassword(String email,String password);
	User findByEmail(String email);
	
	

}
