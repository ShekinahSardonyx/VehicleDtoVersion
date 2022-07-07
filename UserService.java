package com.cg.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dto.UserDto;
import com.cg.entity.User;
import com.cg.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public List<UserDto> addUser(UserDto userDto1) 
	{
		User user = new User();
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDto1, user);
		userRepository.save(user);
		List<UserDto> userDtoList = new ArrayList<>();
		List<User> userList= userRepository.findAll();
		for(User user1 : userList) {
			BeanUtils.copyProperties(user1, userDto);
			userDtoList.add(userDto);
		}
		return userDtoList;
	}

	public String validateUser(int userId ,String Password)
	{
	  if( userRepository.findByUserIdAndPassword(userId, Password) != null) {
		  return "Valid User";
	  }
      return "Invalid user,Please Register";
	}
	
	public List<UserDto> removeUser(int id)
	{
		userRepository.deleteByUserId(id);
		
		List<User> userList = userRepository.findAll();
		List<UserDto> userDtoList = new ArrayList<>();
		UserDto userDto = new UserDto();
		for(User user: userList) {
			BeanUtils.copyProperties(user, userDto);
			userDtoList.add(userDto);
		}
		return userDtoList;
	}
	
	
	public String SignOut(String message) 
	{
		
	   if(message.equals("SignOut")) {
		   return "signed out succesfully";
	   }
	   return "Still Signed in";
	}

}

