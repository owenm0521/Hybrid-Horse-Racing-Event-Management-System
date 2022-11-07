package com.morris.hybridhorseracingeventmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.morris.hybridhorseracingeventmanagement.model.Event;
import com.morris.hybridhorseracingeventmanagement.model.GeneralUser;
import com.morris.hybridhorseracingeventmanagement.model.User;
import com.morris.hybridhorseracingeventmanagement.model.UserRole;
import com.morris.hybridhorseracingeventmanagement.service.CustomUserDetailsService;

@Controller 
public class UserController {
	
	@Autowired
	private CustomUserDetailsService userService; 

	
	@GetMapping("/login")
    public String login(Model model) {
        return "/login";
    }
	
	/* 
	@PostMapping("/process_login")
	public String processLogin(User user) {
		System.out.println(user.getFirstName()); 
		System.out.println(user.getUsername()); 
		System.out.println(user.getPassword()); 
		user.setUserRole(UserRole.USER); 
		userService.saveUser(user);
		return "redirect:/login";
	}
	*/ 
	
	@GetMapping("/signup")
    public String signup(Model model) {
        return "/signup";
    }
	
	@PostMapping("/process_signup")
	public String processSignUp(GeneralUser user) {
		user.setUserRole(UserRole.USER); 
		userService.saveUser(user);
		return "redirect:/login";
	}
	
}
