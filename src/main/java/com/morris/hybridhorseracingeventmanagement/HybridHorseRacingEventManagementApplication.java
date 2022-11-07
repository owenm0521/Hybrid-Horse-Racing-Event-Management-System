package com.morris.hybridhorseracingeventmanagement;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.morris.hybridhorseracingeventmanagement.model.AdminUser;
import com.morris.hybridhorseracingeventmanagement.model.Event;
import com.morris.hybridhorseracingeventmanagement.model.GeneralUser;
import com.morris.hybridhorseracingeventmanagement.model.User;
import com.morris.hybridhorseracingeventmanagement.model.UserRole;
import com.morris.hybridhorseracingeventmanagement.repository.AdminUserRepository;
import com.morris.hybridhorseracingeventmanagement.service.CustomUserDetailsService;
import com.morris.hybridhorseracingeventmanagement.service.EventService;


@SpringBootApplication
public class HybridHorseRacingEventManagementApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(HybridHorseRacingEventManagementApplication.class, args);
	}

}
	
@Component
class DemoCommandLineRunner implements CommandLineRunner{

	@Autowired
	private CustomUserDetailsService userDetailsService;
	@Autowired 
	private EventService eventService; 

	@Override
	public void run(String... args) throws Exception {

		User admin = new AdminUser(); 
		admin.setEmail("admin");
		admin.setPassword("password");
		admin.setUserRole(UserRole.ADMIN);
		userDetailsService.saveUser(admin); 
		
		GeneralUser user = new GeneralUser(); 
		user.setEmail("user");
		user.setPassword("password"); 
		user.setFirstName("First");
		user.setLastName("Last");
		user.setPhone("123");
		user.setUserRole(UserRole.USER);
		userDetailsService.saveUser(user);
		
		for(int i = 0; i < 10; i++) {
			Event e = new Event(); 
			e.setName("Event Test");
			e.setDescription("Description");
			e.setLocation("Location");
			e.setDateTime(LocalDateTime.now().plusYears(1) );
			eventService.saveEvent(e);
			
		}
		
	}
}
