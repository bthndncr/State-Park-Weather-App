package com.techelevator.npgeek.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class User {
	
	@NotBlank(message = "Username is required")
	@Size(min=5, max=20)
	private String username;
	
	@NotBlank(message = "Password is required")
	@Size(min=8, max=16)
	private String password;
	
	public User() {}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
