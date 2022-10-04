package com.morris.hybridhorseracingeventmanagement.service;

import com.morris.hybridhorseracingeventmanagement.model.Event;
import com.morris.hybridhorseracingeventmanagement.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    	/* 
    	List<Event> events = eventRepository.findAll(); 
    	for(int i = 0; i < events.size(); i++) {

    		Event e = events.get(i);

    		if (e.getId() == id) {
    		    events.set(i, event);
    		}
    	 }	
    	 */ 
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
        return eventRepository.findAll();
    }
    
    public List<Event> getUpcomingEvents(){
    	List<Event> all = eventRepository.findAll(); 
    	if(all.size() < 3) {
    		return all; 
    	}
    	return all.subList(0, 3); 
    }

}
