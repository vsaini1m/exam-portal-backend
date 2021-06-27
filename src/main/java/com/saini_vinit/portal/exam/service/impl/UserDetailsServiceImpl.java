package com.saini_vinit.portal.exam.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.saini_vinit.portal.exam.entity.User;
import com.saini_vinit.portal.exam.repositery.UserRepositery;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserRepositery userRepositery;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User findByUsername = userRepositery.findByUsername(username).get();

		if (findByUsername == null)
			throw new UsernameNotFoundException("No user found ||");

		return findByUsername;
	}

}
