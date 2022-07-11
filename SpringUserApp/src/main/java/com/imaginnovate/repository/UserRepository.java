package com.imaginnovate.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imaginnovate.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	

}
