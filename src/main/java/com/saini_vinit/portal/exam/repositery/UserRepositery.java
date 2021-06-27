package com.saini_vinit.portal.exam.repositery;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saini_vinit.portal.exam.entity.User;

@Repository
public interface UserRepositery extends JpaRepository<User, Long>{
											//genratic type < >
	Optional<User> findByUsername(String username);
                                                    
	
	
}
