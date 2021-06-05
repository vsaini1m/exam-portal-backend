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
		
		 Category addCategory = this.categoryService.addCategory(category);
		 
		 
		 return ResponseEntity.ok(addCategory);
	}
	

	@PutMapping("/")
	public ResponseEntity<?> updateCategory(@RequestBody Category category){
		
		
		
		 Category addCategory = this.categoryService.addCategory(category);
		 
		 
		 return ResponseEntity.ok(addCategory);
	}
	
	@GetMapping("/{category_id}")
	public ResponseEntity<?> getCategory(@PathVariable("category_id") Long id) {
		return ResponseEntity.ok(categoryService.getCategoryById(id));
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getAllCategory() {
		return ResponseEntity.ok(categoryService.getCategorys());
	}
	
	@DeleteMapping("/{category_id}")
	public ResponseEntity<?> deleteCategory(@PathVariable("category_id") Long id) {
		
		categoryService.deleteCategoryById(id);
		
		return ResponseEntity.ok().build();
		
	}
	
	

}
