package com.saini_vinit.portal.exam.service;

import java.util.List;

import com.saini_vinit.portal.exam.entity.exam.Question;
import com.saini_vinit.portal.exam.entity.exam.Quiz;

public interface QuestionService {

	
	public Question addQuestion(Question question);
	
	public Question updateQuestion(Question question);
	
	
	public List<Question> getQuestions();
	
	
	public Question getQuestion(Long id);
	
	public void deleteQuestionById(Long id);
	
	public List<Question> getQuestionOfQuiz(Quiz quiz);
	
	
	
}
