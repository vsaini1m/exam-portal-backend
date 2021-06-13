package com.saini_vinit.portal.exam.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.saini_vinit.portal.exam.entity.exam.Quiz;
import com.saini_vinit.portal.exam.repositery.QuizRepositery;
import com.saini_vinit.portal.exam.service.QuizService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuizServiceImpl implements QuizService{

	private final QuizRepositery quizRepositery;
	
	@Override
	public Quiz addQuiz(Quiz quiz) {
		
		return this.quizRepositery.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		
		return this.quizRepositery.save(quiz);
	}

	@Override
	public List<Quiz> getQuizs() {
		
		return this.quizRepositery.findAll();
	}

	@Override
	public Quiz getQuizById(Long id) {
		
		return this.quizRepositery.findById(id).get();
	}

	@Override
	public void deleteQuizById(Long id) {
		
		this.quizRepositery.deleteById(id);
		
		
	}

}
