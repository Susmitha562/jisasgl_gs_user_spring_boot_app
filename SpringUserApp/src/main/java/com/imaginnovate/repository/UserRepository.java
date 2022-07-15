package com.imaginnovate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imaginnovate.dto.UserDto;
import com.imaginnovate.entity.User;

@Repository
public interface UserRepository extends JpaRepository<UserDto, Long>{
	

}
