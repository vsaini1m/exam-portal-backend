package com.saini_vinit.portal.exam.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.saini_vinit.portal.exam.dto.ResultQuizDto;
import com.saini_vinit.portal.exam.entity.exam.Category;
import com.saini_vinit.portal.exam.entity.exam.Quiz;
import com.saini_vinit.portal.exam.repositery.QuizRepositery;
import com.saini_vinit.portal.exam.service.QuizService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuizServiceImpl implements QuizService{

	private final QuizRepositery quizRepositery;
	
	@Override
	public ResultQuizDto addQuiz(Quiz quiz) {
		
		ResultQuizDto resultQuizDto=null;
		
		 Quiz save = this.quizRepositery.save(quiz);
		 
		 if (save!=null) {
			//created
			 
			 resultQuizDto=ResultQuizDto.builder().success(true)
					 .quiz(new ModelMapper().map(save, Quiz.class))
					 .build();
		}else {
			//errrs
			
			List<String> errors=new ArrayList<>();
			errors.add("Quiz creation faild");
			
			resultQuizDto=ResultQuizDto.builder().success(false)
					.errors(errors)
					.build();
		}
		 
		 return resultQuizDto;
	}

	@Override
	public ResultQuizDto updateQuiz(Quiz quiz) {
		ResultQuizDto resultQuizDto=null;
		 Quiz save = this.quizRepositery.save(quiz);
		 
		 if (save!=null) {
			//updated
			 

			 resultQuizDto=ResultQuizDto.builder().success(true)
					 .quiz(new ModelMapper().map(save, Quiz.class))
					 .build();
			 
		}else {
			//error
			List<String> errors=new ArrayList<>();
			errors.add("Quiz update faild");
			
			resultQuizDto=ResultQuizDto.builder().success(false)
					.errors(errors)
					.build();
		}
		 return resultQuizDto;
	}

	@Override
	public List<Quiz> getQuizs() {
		
		return this.quizRepositery.findAll();
	}

	@Override
	public ResultQuizDto getQuizById(Long id) {
		ResultQuizDto resultQuizDto=null;
		 Optional<Quiz> findById = this.quizRepositery.findById(id);
		 
		 if (findById.isPresent()) {
			//found
			 

			 resultQuizDto=ResultQuizDto.builder().success(true)
					 .quiz(new ModelMapper().map(findById.get(), Quiz.class))
					 .build();
			 
		}else {
			//error not found
			
			List<String> errors=new ArrayList<>();
			errors.add("Quiz not found");
			
			resultQuizDto=ResultQuizDto.builder().success(false)
					.errors(errors)
					.build();
		}
		 return resultQuizDto;
	}

	@Override
	public ResultQuizDto deleteQuizById(Long id) {
		ResultQuizDto resultQuizDto=null;
		
		
		try {
			
			
			this.quizRepositery.deleteById(id);

			//success
			
			 resultQuizDto=ResultQuizDto.builder().success(true)
					 .build();
			
		} catch (Exception e) {
			//error
			
			List<String> errors=new ArrayList<>();
			errors.add("Quiz delition faild");
			
			resultQuizDto=ResultQuizDto.builder().success(false)
					.errors(errors)
					.build();
		}
		
		return resultQuizDto;
		
		
	}

	@Override
	public List<Quiz> getQuizsByCategory(Category category) {
		
		
		
		return this.quizRepositery.findBycategory(category);
	}

	@Override
	public List<Quiz> getActiveQuizzes() {
		return this.quizRepositery.findByActive(true);
	}

	@Override
	public List<Quiz> getActiveQuizzesOfCategory(Category c) {
		return this.quizRepositery.findByCategoryAndActive(c,true);
	}

}
