package com.javatpoint.repository;

import org.springframework.data.repository.CrudRepository;

import com.javatpoint.DTO.UserDto;
import com.javatpoint.model.Customers;
import com.javatpoint.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
	User save(UserDto userDto);

}
