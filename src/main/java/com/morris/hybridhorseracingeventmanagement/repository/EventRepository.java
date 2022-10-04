package com.morris.hybridhorseracingeventmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.morris.hybridhorseracingeventmanagement.model.Event;

/**
 * EventRepository
 */
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

	List<Event> findByName(String name); 
	
    boolean existsByName(String name);
    
    Event findById(long id); 
    
    boolean existsById(long id);
}