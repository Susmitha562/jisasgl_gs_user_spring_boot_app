package com.imaginnovate.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imaginnovate.dto.UserDto;
import com.imaginnovate.entity.User;
import com.imaginnovate.repository.UserRepository;
import com.imaginnovate.services.DtoService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private DtoService dtoService;
	
	@Autowired
	private UserRepository userRepository;
	
	
//	@PostMapping("/save/users")
//	public UsersDetails saveusers(@RequestBody UserDataDto usersdto)
//	{
//		return dtoservice.saveusers(dtoservice);
//	}
	
	@PostMapping()
	public ResponseEntity<User> saveEmplyoee(@RequestBody @Valid UserDto userdto){
		System.out.println("UserController.saveUser()");
		return new ResponseEntity<User>(dtoService.saveUser(userdto), HttpStatus.CREATED);
	}
	
	
	@GetMapping()
	public List<User> getAllUsers(){
		return userService.getAllUsers() ;
		
	}
	
	// get all users REST API by id
	
	@GetMapping("{id}")
	public ResponseEntity<User> getEmployyeByID(@PathVariable ("id")long id){
		return new ResponseEntity<User>(userService.getUserById(id),HttpStatus.OK);
		
	}
	
	//build update REST API
	
	@PutMapping("{id}")
	public ResponseEntity<User> updtateEmployee(@PathVariable("id") long id, @RequestBody User user){
		return new ResponseEntity<User>(userService.updateUser(user, id), HttpStatus.OK);
		
	}
	
	//build delete user REST API
	
	@DeleteMapping("{id}")
	public ResponseEntity<String>deleteEmployee(@PathVariable("id")long id){
		userService.deleteUser(id);
		return new ResponseEntity<String>("user deleted successfully",HttpStatus.OK) ;
		
	}



}
