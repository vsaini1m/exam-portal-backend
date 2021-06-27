package com.saini_vinit.portal.exam.dto;

import java.util.List;

import com.saini_vinit.portal.exam.entity.User;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class ResultUserDto {
	
	private boolean success;
	
	private List<String> errors;
	
	private User user;
	

}
