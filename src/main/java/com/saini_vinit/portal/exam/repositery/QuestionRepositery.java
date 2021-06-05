package com.saini_vinit.portal.exam.repositery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saini_vinit.portal.exam.entity.exam.Question;
import com.saini_vinit.portal.exam.entity.exam.Quiz;

@Repository
public interface QuestionRepositery extends JpaRepository<Question, Long>{

	List<Question> findByQuiz(Quiz quiz);

}
