package com.morris.hybridhorseracingeventmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.morris.hybridhorseracingeventmanagement.model.AdminUser;
import com.morris.hybridhorseracingeventmanagement.model.GeneralUser;
import com.morris.hybridhorseracingeventmanagement.model.User;
import com.morris.hybridhorseracingeventmanagement.model.UserRole;
import com.morris.hybridhorseracingeventmanagement.repository.AdminUserRepository;
import com.morris.hybridhorseracingeventmanagement.repository.GeneralUserRepository;
import com.morris.hybridhorseracingeventmanagement.repository.UserBaseRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private GeneralUserRepository genUserRepository; 
	
	@Autowired
	private AdminUserRepository adminUserRepository; 
	
		
	private final static String USER_NOT_FOUND_MSG =
            "User with email %s not found.";
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		if(genUserRepository.existsByEmail(email)) {
			return genUserRepository.findByEmail(email); 
		}
		
		if(adminUserRepository.existsByEmail(email)) {
			return adminUserRepository.findByEmail(email); 
		}
		throw new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email));
	}
	
	public <T extends User> void saveUser(T user) {
		String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
		if(user.getUserRole() == UserRole.ADMIN) {
			if (adminUserRepository.existsByEmail(user.getUsername())) { 
				throw new IllegalStateException("Email already taken.");
			}
			user.setPassword(encodedPassword); 
			adminUserRepository.save((AdminUser) user);
		}else {
			if(genUserRepository.existsByEmail(user.getUsername())) {
				throw new IllegalStateException("Email already taken.");
			}
			user.setPassword(encodedPassword); 
			genUserRepository.save((GeneralUser) user);
		}
		
	}

}
