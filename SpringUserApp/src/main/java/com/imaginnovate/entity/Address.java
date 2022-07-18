package com.imaginnovate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "ADDRESS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Address {
	public Address(int i, String string, String string2, int j, String string3) {
		
	}

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name")
	private String Strret;
	
	@Column(name="name")
	private String city;
	
	@Column(name="name")
	private int zipcode;
	
	@Column(name="name")
	private String state;
	

}
