package com.saini_vinit.portal.exam.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.saini_vinit.portal.exam.dto.ResultQuestionDto;
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
	public ResultQuestionDto addQuestion(Question question) {
		
		ResultQuestionDto resultQuestionDto=null;
		 Question save = this.questionRepositery.save(question);
		 
		 if(save!=null) {
			 //added successfully
			 
			 resultQuestionDto=ResultQuestionDto.builder().success(true)
					 .question(new ModelMapper().map(save, Question.class)).build();
		 }else {
			 //error
			 
			 List<String>errors=new ArrayList<>();
			 errors.add("Question process faild");
			 resultQuestionDto=ResultQuestionDto.builder().success(false)
					 .errors(errors)
					.build();
		 }
			 
		 
		 
		 return resultQuestionDto;
	}

	@Override
	public ResultQuestionDto updateQuestion(Question question) {
		ResultQuestionDto resultQuestionDto=null;
		
		 Question save = this.questionRepositery.save(question);
		 
		 if(save!=null) {
			//updated
			 
			 resultQuestionDto=ResultQuestionDto.builder().success(true)
					 .question(new ModelMapper().map(save, Question.class)).build();
			 
			 
		 }else {
			 //error
			 
			 
			 List<String> errors=new ArrayList<>();
			 
			 errors.add("Question update faild");
			 
			 resultQuestionDto=ResultQuestionDto.builder().success(false)
					 .errors(errors).build();
			 
			 
		 }
		 
		 return resultQuestionDto;
	}

	@Override
	public List<Question> getQuestions() {
		
		return this.questionRepositery.findAll();
	}

	@Override
	public ResultQuestionDto getQuestion(Long id) {
		ResultQuestionDto resultQuestionDto=null;
		
		
		 Optional<Question> findById = this.questionRepositery.findById(id);
		 
		 if(findById.isPresent()) {
			 //quiestion found
			 
			 resultQuestionDto=ResultQuestionDto.builder().success(true)
					 .question(new ModelMapper().map(findById.get(), Question.class)).build();
			 
			 
		 }else {
			 //error not found
			 
			 List<String> errors=new ArrayList<>();
			 
			 errors.add("Question not found");
			
			 
			 resultQuestionDto=ResultQuestionDto.builder().success(false)
					 .errors(errors)
					 .build();
		 }
		 
		 return resultQuestionDto;
	}

	@Override
	public ResultQuestionDto deleteQuestionById(Long id) {
		
		ResultQuestionDto resultQuestionDto=null;
		
		try {
			this.questionRepositery.deleteById(id);
			
			//success
			
			resultQuestionDto=ResultQuestionDto.builder().success(true)
					.build();
		} catch (Exception e) {
			//error
			
			 
			 List<String> errors=new ArrayList<>();
			 
			 errors.add("Question deletion process faild");
			
			 resultQuestionDto=ResultQuestionDto.builder().success(false)
					 .errors(errors).build();
			 
			 
		}
		
		return resultQuestionDto ;
		
	}

	@Override
	public List<Question> getQuestionOfQuiz(Quiz quiz) {
		
		return this.questionRepositery.findByQuiz(quiz);
	}

	
}
