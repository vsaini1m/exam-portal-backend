package com.saini_vinit.portal.exam.dto;

import java.util.List;

import com.saini_vinit.portal.exam.entity.exam.Category;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResultCategoryDto {
	
	private boolean success;
	
	private List<String> errors;
	
	private Category category;
	

}
