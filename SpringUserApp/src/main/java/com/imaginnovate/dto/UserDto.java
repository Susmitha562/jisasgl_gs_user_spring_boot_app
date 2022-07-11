package com.imaginnovate.dto;

import java.util.List;

import com.imaginnovate.entity.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {

	private long id;
	private String name;
	private String username;
	private String email;
	private List<Address> address;
}
