package com.saini_vinit.portal.exam.controller;

import java.security.Principal;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saini_vinit.portal.exam.config.JwtUtil;
import com.saini_vinit.portal.exam.entity.JwtRequest;
import com.saini_vinit.portal.exam.entity.JwtResponse;
import com.saini_vinit.portal.exam.entity.User;
import com.saini_vinit.portal.exam.service.impl.UserDetailsServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class AuthenticateController {

	private final AuthenticationManager authenticationManager;
	private final UserDetailsServiceImpl UserDetailsServiceImpl;
	private final JwtUtil jwtUtil;

	// genrateToken
	@PostMapping("/genrate-token")
	public ResponseEntity<?> genrateToken(@RequestBody JwtRequest jwtRequest) throws Exception {

		try {

			this.authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());

		} catch (UsernameNotFoundException e) {
			e.printStackTrace();

			//throw new Exception("User not found");
			return ResponseEntity
					.badRequest().body("User not found");
		}

		// authenticate

		UserDetails loadUserByUsername = this.UserDetailsServiceImpl.loadUserByUsername(jwtRequest.getUsername());

		String generatedToken = this.jwtUtil.generateToken(loadUserByUsername);

		return ResponseEntity
				.ok(new JwtResponse(generatedToken));

	}
	
	
	//current user
	@GetMapping("/current-user")
	private User getCurrentUsr(Principal principal) {
		return (User)this.UserDetailsServiceImpl.loadUserByUsername(principal.getName());
	}
	
	
	
	

	private void authenticate(String username, String password) throws Exception {

		try {

			authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(username, password));

		} catch (DisabledException e) {
			throw new Exception("USER DISABLED");
		} catch (BadCredentialsException e) {
			throw new Exception("Invalid Credentials" + e.getMessage());
		}

	}
}
