package com.capg.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name="User_Details")
@Data
public class User {
	
	
	 
	@Id
	private Long phoneNumber;
	private String firstname;
	private String lastName;
	private String emailId;
	private String authority;
	private Integer age;
	private String password;
	private Integer walletBalance;
	public User() {
		super();
	}
	
	public User(Long phoneNumber, String password) {
		super();
		this.phoneNumber = phoneNumber;
		this.password = password;
	}

	public User(Long phoneNumber, String firstname, String lastName, String emailId, String authority, Integer age,
			String password, Integer walletBalance) {
		super();
		this.phoneNumber = phoneNumber;
		this.firstname = firstname;
		this.lastName = lastName;
		this.emailId = emailId;
		this.authority = authority;
		this.age = age;
		this.password = password;
		this.walletBalance = walletBalance;
	}
	
	
	
	
	

}
