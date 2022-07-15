package com.imaginnovate.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.imaginnovate.repository.AddressRepository;
import com.imaginnovate.repository.UserRepository;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpringUserAppApplication {
	
	public static void main(String[] args) {
		
		SpringApplication.run(SpringUserAppApplication.class, args);
		
	}

}
