package com.morris.hybridhorseracingeventmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.morris.hybridhorseracingeventmanagement.service.EventService;

@Controller
public class HomeController {
	
	@Autowired 
	 private EventService eventService;

    @GetMapping("/")
    public String home(Model model) {
    	model.addAttribute("events", eventService.getUpcomingEvents()); 
        return "index";
    }

}
