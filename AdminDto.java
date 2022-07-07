package com.cg.dto;

import org.springframework.stereotype.Component;

@Component
public class AdminDto {

	private int adminId;
	private String adminUsername;
	private String adminPassword;
	private String adminEmailId;
	
	public AdminDto() {}

	public AdminDto(int adminId, String adminUsername, String adminPassword, String adminEmailId) {
		super();
		this.adminId = adminId;
		this.adminUsername = adminUsername;
		this.adminPassword = adminPassword;
		this.adminEmailId = adminEmailId;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminUsername() {
		return adminUsername;
	}

	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminEmailId() {
		return adminEmailId;
	}

	public void setAdminEmailId(String adminEmailId) {
		this.adminEmailId = adminEmailId;
	}

	@Override
	public String toString() {
		return "AdminDto [adminId=" + adminId + ", adminUsername=" + adminUsername + ", adminPassword=" + adminPassword
				+ ", adminEmailId=" + adminEmailId + "]";
	}
	
	
}
