package com.saini_vinit.portal.exam.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.saini_vinit.portal.exam.dto.ResultCategoryDto;
import com.saini_vinit.portal.exam.entity.exam.Category;
import com.saini_vinit.portal.exam.repositery.CategoryRepositery;
import com.saini_vinit.portal.exam.service.CategoryService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService{

	
	private final CategoryRepositery categoryRepositery;
	@Override
	public ResultCategoryDto addCategory(Category category) {
		
		ResultCategoryDto resultCategoryDto=null;
		
		 Category save = this.categoryRepositery.save(category);
		 
		 if(save!=null) {
			 //caregory added
			 
			 resultCategoryDto=ResultCategoryDto.builder()
					 .success(true)
					 .category(new ModelMapper().map(save, Category.class)).build();
		 }else {
			 
			
			 //error
			 
			 
			 
			 List<String> errors=new ArrayList<>();
			 
			 errors.add("Category not saved");
			 
			 resultCategoryDto=ResultCategoryDto.builder().success(false).errors(errors).build();
			 
		 }
		
		
		
		return resultCategoryDto;
		
	}

	@Override
	public ResultCategoryDto updateCategory(Category category) {
		
		ResultCategoryDto resultCategoryDto=null;
		
		category.setCId(category.getCId());
		
		
		 Category save = this.categoryRepositery.save(category);
		 
		 if(save!=null){
			 //updated successfully
			 
			 resultCategoryDto=ResultCategoryDto.builder().success(true)
					 .category(new ModelMapper().map(save, Category.class)).build();
			 
			 
		 }else {
			 ///error
			 
			 List<String> errors=new ArrayList<>();
			 
			 resultCategoryDto=ResultCategoryDto.builder().success(false)
					 .errors(errors).build();
		 }
		 
		 
		return resultCategoryDto;
	}

	@Override
	public List<Category> getCategorys() {
		
		return this.categoryRepositery.findAll();
	}

	@Override
	public ResultCategoryDto getCategoryById(Long id) {
		
		ResultCategoryDto resultCategoryDto=null;
		
		
		 Optional<Category> findById = this.categoryRepositery.findById(id);
		
		 
		 if(findById.isPresent()) {
			 //category found
			 
			 resultCategoryDto=ResultCategoryDto.builder().success(true)
					 .category(new ModelMapper().map(findById, Category.class)).build();
		 }else {
			 //error category ot found
			 
			 
			 List<String> errors=new ArrayList<>();
			 resultCategoryDto=ResultCategoryDto.builder().success(false)
					 .errors(errors)
					 .build();
		 }
		
		 return resultCategoryDto;
		 
		
		
	}

	@Override
	public ResultCategoryDto deleteCategoryById(Long id) {
		
		ResultCategoryDto resultCategoryDto=null;
		
		
		 
		
		try {
			
			this.categoryRepositery.deleteById(id);
			
			
			
			resultCategoryDto=ResultCategoryDto.builder().success(true).build();
		} catch (Exception e) {
			
			List<String> errors=new ArrayList<>();
			
			
			resultCategoryDto=ResultCategoryDto.builder().success(false).errors(errors).build();
		}
		
		
		return resultCategoryDto;
		
		
	}

}
