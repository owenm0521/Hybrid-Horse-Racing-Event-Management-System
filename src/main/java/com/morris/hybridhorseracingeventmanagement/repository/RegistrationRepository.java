package com.morris.hybridhorseracingeventmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.morris.hybridhorseracingeventmanagement.model.Registration;

/*
 * Registration Repository
 */
@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {

	List<Registration> findByUserEmail(String userEmail); 
	
	List<Registration> findByEventId(long eventId); 
    
    Registration findById(long id); 
    
    boolean existsById(long id);
}