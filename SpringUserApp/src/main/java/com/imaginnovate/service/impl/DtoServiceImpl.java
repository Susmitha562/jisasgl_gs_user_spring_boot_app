package com.imaginnovate.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imaginnovate.entity.User;
import com.imaginnovate.exception.ResourceNofoundException;
import com.imaginnovate.repository.AddressRepository;
import com.imaginnovate.repository.UserRepository;
import com.imaginnovate.services.DtoService;

@Service
public class DtoServiceImpl implements DtoService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	AddressRepository addressRepository;

	ModelMapper modelmapper = new ModelMapper();
	
    //for save method
	public DtoServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	
	@Override
	public User saveUser(DtoService dtoservice) {
		User user = modelmapper.map(dtoservice, User.class);
		return userRepository.save(user);
	}
	
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}


	@Override
	public User getUserById(long id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public User updateUser(User user, long id) {
		User exitingUser = userRepository.findById(id).orElseThrow(()->new  ResourceNofoundException ("User","ID",id));
		exitingUser.setName(user.getName());
		exitingUser.setUsername(user.getUsername());
		exitingUser.setEmail(user.getEmail());
		return exitingUser;
	}
	

	@Override
	public void deleteUser(long id) {
		userRepository.findById(id).orElseThrow(() -> new  ResourceNofoundException ("User","ID",id));
		userRepository.deleteById(id);
		
	}


	
}
