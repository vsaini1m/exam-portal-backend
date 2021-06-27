package com.saini_vinit.portal.exam.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.saini_vinit.portal.exam.dto.ResultUserDto;
import com.saini_vinit.portal.exam.entity.User;
import com.saini_vinit.portal.exam.entity.UserRole;
import com.saini_vinit.portal.exam.repositery.RoleRepositery;
import com.saini_vinit.portal.exam.repositery.UserRepositery;
import com.saini_vinit.portal.exam.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class UserServiceImpl implements UserService {

	private final UserRepositery userRepositery;
	private final RoleRepositery roleRepositery;
	private final BCryptPasswordEncoder passwordEncoder;
	

	@Override
	public ResultUserDto createUser(User user, List<UserRole> userRole) throws Exception {
 
		
		ResultUserDto resultUserDto=null;
		
	
		
		
		
		  Optional<User> findByUsername = this.userRepositery.findByUsername(user.getUsername());
		  
		  
		  
		  if(findByUsername.isPresent()) {
			 //already present user
			  
			  List<String> errors=new ArrayList<>();
			  
			  errors.add("User already present");
			  
			  resultUserDto=ResultUserDto.builder().success(false).errors(errors).build();
			  
			  
		  }else {
			  for(UserRole ur:userRole) {
					roleRepositery.save(ur.getRole());
				}
				user.getUserRoles().addAll(userRole);
				
				user.setPassword(passwordEncoder.encode(user.getPassword()));
				
				
				
				User savedUser = this.userRepositery.save(user);
				
				resultUserDto= ResultUserDto.builder().success(true).user(new ModelMapper().map(savedUser, User.class)).build();
		  }
		  

		return resultUserDto;
	}

	@Override
	public ResultUserDto getUserByUserName(String username) {
		
		ResultUserDto resultUserDto=null;
		
		
		 Optional<User> findByUsername = this.userRepositery.findByUsername(username);
		 
		 if(findByUsername.isPresent()) {
			 //success
			 resultUserDto= ResultUserDto.builder().success(true).user(new ModelMapper().map(findByUsername, User.class)).build();
		 }else {
			 //user not found
			 
			List<String> errors=new ArrayList<>();
			
			errors.add("User not found.");
			
			resultUserDto=ResultUserDto.builder().success(false).errors(errors).build();
			 
		 }
		 
		 
		 return resultUserDto;
	}

}
