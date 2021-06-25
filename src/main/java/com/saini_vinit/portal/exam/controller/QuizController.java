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
import com.saini_vinit.portal.exam.entity.exam.Quiz;
import com.saini_vinit.portal.exam.service.QuizService;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
@AllArgsConstructor
public class QuizController {

	private final QuizService quizService;
	
	@PostMapping("/")
	public ResponseEntity<?> addQuiz(@RequestBody Quiz quiz) {
		
		return ResponseEntity.ok(quizService.addQuiz(quiz));
	}
	
	@PutMapping("/")
	public ResponseEntity<?> updateQuiz(@RequestBody Quiz quiz) {
		
		return ResponseEntity.ok(quizService.updateQuiz(quiz));
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getQuizzes() {
		
		return ResponseEntity.ok(quizService.getQuizs());
	}
	@GetMapping("/{quiz_id}")
	public ResponseEntity<?> getQuiz(@PathVariable("quiz_id") Long id) {
		
		return ResponseEntity.ok(quizService.getQuizById(id));
	}
	
	@DeleteMapping("/{quiz_id}")
	public ResponseEntity<?> deleteQuiz(@PathVariable("quiz_id") Long id) {
		System.out.println("id deleted"+id);
		quizService.deleteQuizById(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/category/{category_id}")
	public ResponseEntity<?> getQuizByCategory(@PathVariable("category_id") Long id) {
		
		Category category = new Category();
		category.setCId(id);
		
		return ResponseEntity.ok(quizService.getQuizsByCategory(category));
		
		
	}
	
	
	
}
