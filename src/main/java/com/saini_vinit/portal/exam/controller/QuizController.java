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

import com.saini_vinit.portal.exam.dto.ResultQuizDto;
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
		
		
		ResultQuizDto addQuiz = quizService.addQuiz(quiz);
		return addQuiz.isSuccess()?
				ResponseEntity.ok(addQuiz.getQuiz()):
					ResponseEntity.badRequest().body(addQuiz.getErrors());
	}
	
	@PutMapping("/")
	public ResponseEntity<?> updateQuiz(@RequestBody Quiz quiz) {
		ResultQuizDto updateQuiz = quizService.updateQuiz(quiz);
		
		return updateQuiz.isSuccess()?
				ResponseEntity.ok(updateQuiz.getQuiz()):
					ResponseEntity.badRequest().body(updateQuiz.getErrors());
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getQuizzes() {
		
		return ResponseEntity.ok(quizService.getQuizs());
	}
	@GetMapping("/{quiz_id}")
	public ResponseEntity<?> getQuiz(@PathVariable("quiz_id") Long id) {
		ResultQuizDto quizById = quizService.getQuizById(id);
		return quizById.isSuccess()?
				ResponseEntity.ok(quizById.getQuiz()):
					ResponseEntity.badRequest().body(quizById.getErrors());
		
	}
	
	@DeleteMapping("/{quiz_id}")
	public ResponseEntity<?> deleteQuiz(@PathVariable("quiz_id") Long id) {
		
		ResultQuizDto deleteQuizById = quizService.deleteQuizById(id);
		return deleteQuizById.isSuccess()?
				ResponseEntity.ok().build():
					ResponseEntity.badRequest().body(deleteQuizById.getErrors());
	}
	
	@GetMapping("/category/{category_id}")
	public ResponseEntity<?> getQuizByCategory(@PathVariable("category_id") Long id) {
		
		Category category = new Category();
		category.setCId(id);
		
		return ResponseEntity.ok(quizService.getQuizsByCategory(category));
		
		
	}
	
	
	
	@GetMapping("/active")
	public ResponseEntity<?> getAciveQuizzes() {
		
		return ResponseEntity.ok(quizService.getActiveQuizzes());
	}
	
	@GetMapping("/category/active/{category_id}")
	public ResponseEntity<?> getActiveQuizByCategory(@PathVariable("category_id") Long id) {
		
		Category category = new Category();
		category.setCId(id);
		
		return ResponseEntity.ok(quizService.getActiveQuizzesOfCategory(category));
		
		
	}
}
