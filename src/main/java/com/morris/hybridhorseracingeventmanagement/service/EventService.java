package com.morris.hybridhorseracingeventmanagement.service;

import com.morris.hybridhorseracingeventmanagement.model.Event;
import com.morris.hybridhorseracingeventmanagement.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * EventService
 */
@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public void saveEvent(Event event) {
        eventRepository.save(event);
    }
    
    public void updateEvent(Event event) {
    	eventRepository.save(event);
    }
    
    public void deleteEvent(long id) {
    	eventRepository.deleteById(id);
    }	
    
    public boolean existsByName(String name) {
        return eventRepository.existsByName(name);
    }

    public boolean existsById(int id) {
        return eventRepository.existsById(id);
    }
    
    public List<Event> getEventsByName(String name){
    	return eventRepository.findByName(name); 
    }
    
    public Event getEventById(long id) {
    	return eventRepository.findById(id); 
    }
    
    public List<Event> getAllEvents() {
        return eventRepository.findAll().stream()
        		.sorted(Comparator.comparing(Event :: getDateTime))
        		.collect(Collectors.toList());
    }
    
    public List<Event> getUpcomingEvents(){
    	List<Event> upcoming = new ArrayList<Event>(); 
    	List<Event> all = this.getAllEvents(); 
    	for(int i = 0, j = 0; i < all.size() && j < 3; i++) {
    		Event e = all.get(i); 
    		if(e.getDateTime().isAfter(LocalDateTime.now())) {
    			upcoming.add(e); 
    			j++; 
    		}
    	}
    	return upcoming; 
    }

}
