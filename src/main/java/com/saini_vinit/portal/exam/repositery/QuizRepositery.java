package com.saini_vinit.portal.exam.repositery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saini_vinit.portal.exam.entity.exam.Category;
import com.saini_vinit.portal.exam.entity.exam.Quiz;

@Repository
public interface QuizRepositery extends JpaRepository<Quiz, Long>{

	List<Quiz> findBycategory(Category category);

}
