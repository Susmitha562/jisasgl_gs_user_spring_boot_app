package com.imaginnovate.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.imaginnovate.repository.AddressRepository;
import com.imaginnovate.repository.UserRepository;

@SpringBootApplication
//@ComponentScan("com.imaginnovate.repositories")
public class SpringUserAppApplication {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	public static void main(String[] args) {
		
		SpringApplication.run(SpringUserAppApplication.class, args);
		
	}

}
