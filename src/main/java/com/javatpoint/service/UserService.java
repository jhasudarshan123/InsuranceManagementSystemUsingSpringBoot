package com.javatpoint.service;

import com.javatpoint.DTO.UserDto;
import com.javatpoint.model.User;

public interface UserService {
	User findByUsername(String username);
	User save(UserDto userDto);

}
