package com.morris.hybridhorseracingeventmanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import com.morris.hybridhorseracingeventmanagement.model.User;

/*
 * All Users Base Repository
 */
@NoRepositoryBean
public interface UserBaseRepository<T extends User> extends JpaRepository<T, Long> {

	T findByEmail(String userEmail); 
	
	T findById(long Id); 
    
    boolean existsByEmail(String email); 
    
	boolean existsById(long id);
}
