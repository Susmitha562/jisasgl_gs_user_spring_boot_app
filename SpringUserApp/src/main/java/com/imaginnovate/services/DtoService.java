package com.imaginnovate.services;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imaginnovate.dto.UserDto;
import com.imaginnovate.entity.User;
import com.imaginnovate.repository.UserRepository;


public interface DtoService {
	
	    User saveUser(UserDto userdto); 
		List<User> getAllUsers(int i);
		User getUserById(long id);
		User updateUser(User user,long id);
		void deleteUser(long id);
		
		
	}



