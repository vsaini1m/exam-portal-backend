package com.saini_vinit.portal.exam.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saini_vinit.portal.exam.entity.Role;
import com.saini_vinit.portal.exam.entity.User;
import com.saini_vinit.portal.exam.entity.UserRole;
import com.saini_vinit.portal.exam.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("saini_vinit/exam/api/user/")
@CrossOrigin("*")
public class UserController {
	
	private final UserService userService;

	@PostMapping("/register")
	public User createUser(@RequestBody User user) throws Exception {
		
		List<UserRole> roles=new ArrayList<>();
		
		Role role=new Role();
		
		role.setRoleName("NORMAL");
		
		UserRole userRole=new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		
		roles.add(userRole);
		
		
		return this.userService.createUser(user, roles);
		
	}
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		
		return this.userService.getUserByUserName(username);
	}
	
	
}
