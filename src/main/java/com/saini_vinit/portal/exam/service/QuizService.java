package com.saini_vinit.portal.exam.service;

import java.util.List;

import com.saini_vinit.portal.exam.dto.ResultQuizDto;
import com.saini_vinit.portal.exam.entity.exam.Category;
import com.saini_vinit.portal.exam.entity.exam.Quiz;

public interface QuizService {

	public ResultQuizDto addQuiz(Quiz quiz);
	
	public ResultQuizDto updateQuiz(Quiz quiz);
	
	public List<Quiz> getQuizs();
	
	public ResultQuizDto getQuizById(Long id);
	
	
	public ResultQuizDto deleteQuizById(Long id);
	
	public List<Quiz> getQuizsByCategory(Category id);
	
	public List<Quiz> getActiveQuizzes();
	
	public List<Quiz> getActiveQuizzesOfCategory(Category c);
	
	
	
}
