package com.saini_vinit.portal.exam.repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saini_vinit.portal.exam.entity.Role;

@Repository
public interface RoleRepositery extends JpaRepository<Role, Long>{

}
