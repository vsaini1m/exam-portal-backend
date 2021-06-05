package com.saini_vinit.portal.exam.service;

import java.util.List;

import com.saini_vinit.portal.exam.entity.exam.Category;

public interface CategoryService {
	
	public Category addCategory(Category category);
	
	public Category updateCategory(Category category);
	
	public List<Category> getCategorys();
	
	public Category getCategoryById(Long id);
	
	public void deleteCategoryById(Long id);
	
	
}
