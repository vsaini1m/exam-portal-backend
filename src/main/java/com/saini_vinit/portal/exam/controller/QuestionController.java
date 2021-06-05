package com.saini_vinit.portal.exam.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saini_vinit.portal.exam.entity.exam.Question;
import com.saini_vinit.portal.exam.entity.exam.Quiz;
import com.saini_vinit.portal.exam.service.QuestionService;
import com.saini_vinit.portal.exam.service.QuizService;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping("/question")
public class QuestionController {

	private final QuestionService questionService;
	private final QuizService  quizService;
	
	@PostMapping("/")
	public ResponseEntity<?> addQuestion(@RequestBody Question question) {
		
		return ResponseEntity.ok(questionService.addQuestion(question));
	}
	@PutMapping("/")
	public ResponseEntity<?> updateQuestion(@RequestBody Question question) {
		
		return ResponseEntity.ok(questionService.updateQuestion(question));
	}
	
	@GetMapping("/quiz/{qid}")
	public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("qid") Long id) {
		
//		Quiz quiz = new Quiz();
//		quiz.setQId(id);
//		
//		
//		
//		return ResponseEntity.ok(questionService.getQuestionOfQuiz(quiz));
		
		
		Quiz quizById = this.quizService.getQuizById(id);
		
		List<Question> questions = quizById.getQuestions();
		
		if(questions.size()>Integer.parseInt(quizById.getNumberOfQuestions())) {
			questions=questions.subList(0, Integer.parseInt(quizById.getNumberOfQuestions())+1);
		}
		
		Collections.shuffle(questions);
		
		return ResponseEntity.ok(questions);
		
	}
	
	@GetMapping("/{question}")
	public ResponseEntity<?> getQuestion(@PathVariable("question") Long id) {
		
		return ResponseEntity.ok(questionService.getQuestion(id));
	}
	@DeleteMapping("/{question}")
	public ResponseEntity<?> deleteQuestion(@PathVariable("question") Long id) {
		questionService.deleteQuestionById(id);
		return ResponseEntity.ok().build();
	}
}
