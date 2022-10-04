package com.morris.hybridhorseracingeventmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.morris.hybridhorseracingeventmanagement.model.Event;
import com.morris.hybridhorseracingeventmanagement.service.EventService;
import com.morris.hybridhorseracingeventmanagement.service.RegistrationService;

@Controller
@RequestMapping("/events")
public class EventController {
	
  @Autowired 
  private EventService eventService;
  @Autowired
  private RegistrationService registrationService; 
  
  @RequestMapping("/getAll")
  public String events(Model model) {
	model.addAttribute("events", eventService.getAllEvents()); 
    return "events";
  }
  
  @RequestMapping("/getEvent") 
  @ResponseBody
  public Event getEvent(long id) {
  	return eventService.getEventById(id);
  }
  
  @PostMapping("/addNew")
  public String addEvent(Event event) {
      eventService.saveEvent(event);
      return "redirect:/events/getAll";
  }
  
  @RequestMapping(value="/update", method = {RequestMethod.PUT, RequestMethod.GET})
  public String updateEvent(Event event) {
	  eventService.updateEvent(event); 
	  return "redirect:/events/getAll";
  }
  
  @RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
  public String delete(long id) {
  	eventService.deleteEvent(id);
  	return "redirect:/events/getAll";
  }
  

  /*
  @PostMapping()
  public String addRegistration(@ModelAttribute("registration") Registration registration, Model model) {
      registrationService.saveRegistration(registration); 
      return "events";
  }
  */
 
  
}