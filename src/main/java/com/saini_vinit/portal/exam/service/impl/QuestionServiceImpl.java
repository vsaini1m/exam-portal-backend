package com.saini_vinit.portal.exam.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.saini_vinit.portal.exam.entity.exam.Question;
import com.saini_vinit.portal.exam.entity.exam.Quiz;
import com.saini_vinit.portal.exam.repositery.QuestionRepositery;
import com.saini_vinit.portal.exam.service.QuestionService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService{
	
	private final QuestionRepositery questionRepositery;
	
	@Override
	public Question addQuestion(Question question) {
		
		return this.questionRepositery.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		
		return this.questionRepositery.save(question);
	}

	@Override
	public List<Question> getQuestions() {
		
		return this.questionRepositery.findAll();
	}

	@Override
	public Question getQuestion(Long id) {
		
		return this.questionRepositery.findById(id).get();
	}

	@Override
	public void deleteQuestionById(Long id) {
		
		this.questionRepositery.deleteById(id);
		
	}

	@Override
	public List<Question> getQuestionOfQuiz(Quiz quiz) {
		
		return null;
	}

	
}
