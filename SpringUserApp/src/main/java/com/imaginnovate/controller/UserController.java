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

	@PostMapping("/save/users")
	public User saveusers(@RequestBody UserDto userdto)
	{
		return dtoService.saveUser(userdto);
	}
	
	@PostMapping()
	public ResponseEntity<User> saveEmplyoee(@RequestBody @Valid UserDto userdto){
		System.out.println("UserController.saveUser()");
		return new ResponseEntity<User>(dtoService.saveUser(userdto), HttpStatus.CREATED);
	}
	
	
	@GetMapping()
	public List<User> getAllUsers(){
		return dtoService.getAllUsers() ;
		
	}
	
	
	@GetMapping("{id}")
	public ResponseEntity<User> getEmployyeByID(@PathVariable ("id")long id){
		return new ResponseEntity<User>(dtoService.getUserById(id),HttpStatus.OK);
		
	}
	
	
	@PutMapping("{id}")
	public ResponseEntity<User> updtateEmployee(@PathVariable("id") long id, @RequestBody User user){
		return new ResponseEntity<User>(dtoService.updateUser(user, id), HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<String>deleteEmployee(@PathVariable("id")long id){
		dtoService.deleteUser(id);
		return new ResponseEntity<String>("user deleted successfully",HttpStatus.OK) ;
		
	}



}
