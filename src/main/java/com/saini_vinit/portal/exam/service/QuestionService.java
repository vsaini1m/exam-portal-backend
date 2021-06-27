package com.saini_vinit.portal.exam.service;

import java.util.List;

import com.saini_vinit.portal.exam.dto.ResultQuestionDto;
import com.saini_vinit.portal.exam.entity.exam.Question;
import com.saini_vinit.portal.exam.entity.exam.Quiz;

public interface QuestionService {

	
	public ResultQuestionDto addQuestion(Question question);
	
	public ResultQuestionDto updateQuestion(Question question);
	
	
	public List<Question> getQuestions();
	
	
	public ResultQuestionDto getQuestion(Long id);
	
	public ResultQuestionDto deleteQuestionById(Long id);
	
	public List<Question> getQuestionOfQuiz(Quiz quiz);
	
	
	
}
