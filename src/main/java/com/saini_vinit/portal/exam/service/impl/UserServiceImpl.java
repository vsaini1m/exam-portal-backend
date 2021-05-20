package com.saini_vinit.portal.exam.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

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
	

	@Override
	public User createUser(User user, List<UserRole> userRole) throws Exception {

		// check already
		User local = this.userRepositery.findByUsername(user.getUsername());

		if (local != null) {

			throw new Exception("already registerd");

		} else {
			
			for(UserRole ur:userRole) {
				roleRepositery.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRole);
			
			local=this.userRepositery.save(user);
		}

		return local;
	}

	@Override
	public User getUserByUserName(String username) {
		return this.userRepositery.findByUsername(username);
	}

}
