package com.morris.hybridhorseracingeventmanagement.model;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@MappedSuperclass
public class User implements UserDetails {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")	
	protected long id; 
	
	@Column(name = "email", unique = true, nullable = false)
	protected String email; 
	
	@Column(name = "password", nullable = false)
	protected String password; 
	
	@Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    protected UserRole userRole;
	
	
	public long getId() {
		return id; 
	}
	
	public void setId(long id) {
		this.id = id; 
	}
	
	@Override
	public String getUsername() {
		return this.getEmail();
	}
	
	public String getEmail() {
		return email; 
	}
	
	public void setEmail(String email) {
		this.email = email; 
	}
	
	public  String getPassword() {
		return password; 
	}
	
	public void setPassword(String password) {
		this.password = password; 
	}
	
	public UserRole getUserRole() {
		return userRole; 
	}
	
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole; 
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority =
                new SimpleGrantedAuthority(userRole.name());
        return Collections.singletonList(authority);
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
