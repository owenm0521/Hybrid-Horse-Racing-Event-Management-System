package com.morris.hybridhorseracingeventmanagement.model;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "admin")
public class AdminUser extends User implements UserDetails{
    
    public AdminUser(String email, String password, UserRole userRole) {
        this.email = email;
        this.password = password;
        this.userRole = userRole; 
    }

    public AdminUser() {

    }
    
}
