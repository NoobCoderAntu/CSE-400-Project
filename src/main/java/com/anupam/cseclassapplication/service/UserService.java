package com.anupam.cseclassapplication.service;

import com.anupam.cseclassapplication.dto.UserDto;
import com.anupam.cseclassapplication.entity.User;

public interface UserService {
	
	User save (UserDto userDto);
	
}
