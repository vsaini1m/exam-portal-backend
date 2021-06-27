package com.saini_vinit.portal.exam.controller;

import java.util.Collections;
import java.util.List;

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

import com.saini_vinit.portal.exam.dto.ResultQuestionDto;
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
		
		ResultQuestionDto addQuestion = questionService.addQuestion(question);
		
		return addQuestion.isSuccess()?
				ResponseEntity.ok(addQuestion.getQuestion()):
					ResponseEntity.badRequest().body(addQuestion.getErrors());
		
		
		
	}
	@PutMapping("/")
	public ResponseEntity<?> updateQuestion(@RequestBody Question question) {
		ResultQuestionDto updateQuestion = questionService.updateQuestion(question);
		
		return updateQuestion.isSuccess()?
				ResponseEntity.ok(updateQuestion.getQuestion()):
					ResponseEntity.badRequest().body(updateQuestion.getErrors());
	}
	
	@GetMapping("/questions/{qid}")
	public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("qid") Long id) {
		
//		Quiz quiz = new Quiz();
//		quiz.setQId(id);
//		
//		
//		
//		return ResponseEntity.ok(questionService.getQuestionOfQuiz(quiz));
		
		
		Quiz quizById = this.quizService.getQuizById(id).getQuiz();
		
		List<Question> questions = quizById.getQuestions();
		
		if(questions.size()>Integer.parseInt(quizById.getNumberOfQuestion())) {
			questions=questions.subList(0, Integer.parseInt(quizById.getNumberOfQuestion())+1);
		}
		
		Collections.shuffle(questions);
		
		return ResponseEntity.ok(questions);
		
	}
	
	

	@GetMapping("/questions/all/{qid}")
	public ResponseEntity<?> getQuestionsOfQuizForAdmin(@PathVariable("qid") Long id) {
		
		Quiz quiz = new Quiz();
		quiz.setQId(id);
			
		return ResponseEntity.ok(questionService.getQuestionOfQuiz(quiz));		
		
		
	}
	@GetMapping("/{question}")
	public ResponseEntity<?> getQuestion(@PathVariable("question") Long id) {
		
		ResultQuestionDto question = questionService.getQuestion(id);
		return question.isSuccess()?
				ResponseEntity.ok(question.getQuestion()):
					ResponseEntity.badRequest().body(question.getErrors());
		
	}
	@DeleteMapping("/{question}")
	public ResponseEntity<?> deleteQuestion(@PathVariable("question") Long id) {
		ResultQuestionDto deleteQuestionById = questionService.deleteQuestionById(id);
		return deleteQuestionById.isSuccess()?
				ResponseEntity.ok(""):
					ResponseEntity.badRequest().body(deleteQuestionById.getErrors());
	}
}
