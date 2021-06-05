package com.saini_vinit.portal.exam.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.saini_vinit.portal.exam.entity.exam.Category;
import com.saini_vinit.portal.exam.repositery.CategoryRepositery;
import com.saini_vinit.portal.exam.service.CategoryService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService{

	
	private final CategoryRepositery categoryRepositery;
	@Override
	public Category addCategory(Category category) {
		
		
		return this.categoryRepositery.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		
		category.setCId(category.getCId());
		
		return this.categoryRepositery.save(category);
	}

	@Override
	public List<Category> getCategorys() {
		
		return this.categoryRepositery.findAll();
	}

	@Override
	public Category getCategoryById(Long id) {
		
		return this.categoryRepositery.findById(id).get();
	}

	@Override
	public void deleteCategoryById(Long id) {
		this.categoryRepositery.deleteById(id);
		
	}

}
