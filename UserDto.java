package com.cg.dto;

import org.springframework.stereotype.Component;

@Component
public class UserDto {

	 private String UserId;
	
	 private String password;
	
	 private String role;
	 

	 public UserDto() {}


	public UserDto(String userId, String password, String role) {
		super();
		UserId = userId;
		this.password = password;
		this.role = role;
	}


	public String getUserId() {
		return UserId;
	}


	public void setUserId(String userId) {
		UserId = userId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "UserDto [UserId=" + UserId + ", password=" + password + ", role=" + role + "]";
	}
	
	
}
