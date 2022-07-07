package com.cg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dto.AdminDto;
import com.cg.entity.Admin;

import com.cg.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	public String addAdmin(AdminDto adminDto) {
		
		Admin admin = new Admin();
		BeanUtils.copyProperties(adminDto, admin);
		adminRepository.save(admin);
		return "Admin added successfully";
	}
	
	public AdminDto updateAdminPassword(int id, String pwd) {
		
		Admin admin = new Admin();
		AdminDto adminDto = new AdminDto();
		BeanUtils.copyProperties(adminRepository.findById(id).get(), adminDto);
		adminDto.setAdminPassword(pwd);
		BeanUtils.copyProperties(adminDto, admin);
		adminRepository.flush();
		return adminDto;
	}
	
	public AdminDto updateAdminName(int id, String username) {
		Admin admin = new Admin();
		AdminDto adminDto = new AdminDto();
		BeanUtils.copyProperties(adminRepository.findById(id).get(), adminDto);
		adminDto.setAdminUsername(username);
		BeanUtils.copyProperties(adminDto, admin);
		adminRepository.flush();
		return adminDto;
	}
	public List<AdminDto> deleteAdmin(int id) {
		adminRepository.deleteById(id);
		AdminDto adminDto = new AdminDto();
		List<Admin> adminList = adminRepository.findAll();
		List<AdminDto> adminDtoList = new ArrayList<>();
		for(Admin admin : adminList) {
			BeanUtils.copyProperties(admin, adminDto);
			adminDtoList.add(adminDto);
		}
		return adminDtoList;
	}
	
}
