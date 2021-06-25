package com.saini_vinit.portal.exam.service;

import java.util.List;

import com.saini_vinit.portal.exam.entity.exam.Category;
import com.saini_vinit.portal.exam.entity.exam.Quiz;

public interface QuizService {

	public Quiz addQuiz(Quiz quiz);
	
	public Quiz updateQuiz(Quiz quiz);
	
	public List<Quiz> getQuizs();
	
	public Quiz getQuizById(Long id);
	
	
	public void deleteQuizById(Long id);
	
	public List<Quiz> getQuizsByCategory(Category id);
	
	
	
	
	
}
