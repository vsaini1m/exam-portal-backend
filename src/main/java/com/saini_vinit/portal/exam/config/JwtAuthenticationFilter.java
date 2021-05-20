package com.saini_vinit.portal.exam.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.saini_vinit.portal.exam.service.impl.UserDetailsServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter{

	
	private final UserDetailsServiceImpl userDetailsServiceImpl;
	private final JwtUtil jwtUtil;
	
	
	
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		
		final String requestTokenHeader = request.getHeader("Authorization");
		
		
		System.out.println(requestTokenHeader);
		
		String username=null;
		String jwtToken=null;
		
		
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer ")) {
			
			
			jwtToken=requestTokenHeader.substring(7);
			
			try {
				username = this.jwtUtil.extractUsername(jwtToken);
				
			} catch (ExpiredJwtException e) {
				// TODO: handle exception
			System.out.println("jwt token has expired");
			e.printStackTrace();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}else {
			System.out.println("invalid token not start with bearer string");
		}
		
		
		
		
		///valided
		
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			
			
			final UserDetails loadUserByUsername = this.userDetailsServiceImpl.loadUserByUsername(username);
			
			if(this.jwtUtil.validateToken(jwtToken, loadUserByUsername)) {
				//token is valid
				
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=
						new UsernamePasswordAuthenticationToken(loadUserByUsername,null,loadUserByUsername.getAuthorities());
				
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
			
		}else {
			System.out.println("Token is not valid");
		}
		
		
		filterChain.doFilter(request, response);
		
		
		
	}

	
}
