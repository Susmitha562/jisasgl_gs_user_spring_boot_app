package com.imaginnovate.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imaginnovate.dto.UserDto;
import com.imaginnovate.entity.User;
import com.imaginnovate.repository.AddressRepository;
import com.imaginnovate.services.DtoService;

@Service
public class DtoServiceImpl implements DtoService{

	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	DtoService dtoService;

	ModelMapper modelmapper = new ModelMapper();
	
    //for save method
	public DtoServiceImpl(DtoService dtoService) {
		super();
		this.dtoService = dtoService;
	}
	
	
	@Override
	public User saveUser(UserDto userDto) {
		User user = modelmapper.map(userDto, User.class);
		return dtoService.saveUser(userDto);
	}
	
//	@Override
//	public List<User> getAllUsers() {
//		return dtoService.getAllUsers();
//	}


	@Override
	public User getUserById(long id) {
		return dtoService.getUserById(id);
	}

	@Override
	public User updateUser(User user, long id) {
		User exitingUser = dtoService.getUserById(id);
		exitingUser.setName(user.getName());
		exitingUser.setUsername(user.getUsername());
		exitingUser.setEmail(user.getEmail());
		return exitingUser;
	}
	

	@Override
	public void deleteUser(long id) {
		dtoService.getUserById(id);
		dtoService.deleteUser(id);
		
	}


	@Override
	public List<User> getAllUsers(int i) {
		// TODO Auto-generated method stub
		return null;
	}


	


	


	
}
