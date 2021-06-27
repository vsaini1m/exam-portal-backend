package com.saini_vinit.portal.exam.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saini_vinit.portal.exam.dto.ResultCategoryDto;
import com.saini_vinit.portal.exam.entity.exam.Category;
import com.saini_vinit.portal.exam.service.CategoryService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/category")
@AllArgsConstructor
@CrossOrigin("*")
public class CategoryController {
	
	private final CategoryService categoryService;
	
	
	
	@PostMapping("/")
	public ResponseEntity<?> addCategory(@RequestBody Category category){
		
		 ResultCategoryDto addCategory = this.categoryService.addCategory(category);
		 
		 return addCategory.isSuccess()?
				 ResponseEntity.ok(addCategory.getCategory()):
					 ResponseEntity.badRequest().body(addCategory.getErrors());
		 
		 
	}
	

	@PutMapping("/")
	public ResponseEntity<?> updateCategory(@RequestBody Category category){
		
		
		
		 ResultCategoryDto addCategory = this.categoryService.addCategory(category);
		 
		 
		 return addCategory.isSuccess()?
				 ResponseEntity.ok(addCategory.getCategory()):
					 ResponseEntity.badRequest().body(addCategory.getErrors());
		 
		 
	}
	
	@GetMapping("/{category_id}")
	public ResponseEntity<?> getCategory(@PathVariable("category_id") Long id) {
		
		ResultCategoryDto categoryById = this.categoryService.getCategoryById(id);
		
		return categoryById.isSuccess()?
				ResponseEntity.ok(categoryById.getCategory()):
					ResponseEntity.badRequest().body(categoryById.getErrors());
		
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getAllCategory() {
		return ResponseEntity.ok(categoryService.getCategorys());
	}
	
	@DeleteMapping("/{category_id}")
	public ResponseEntity<?> deleteCategory(@PathVariable("category_id") Long id) {
		
		ResultCategoryDto deleteCategoryById = categoryService.deleteCategoryById(id);
		
		return deleteCategoryById.isSuccess()?
				ResponseEntity.ok(""):
					ResponseEntity.badRequest().body(deleteCategoryById.getErrors());
		
	}
	
	

}
