package com.morris.hybridhorseracingeventmanagement.model;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users")
public class GeneralUser extends User {
    
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "metamask")
    private String metamask;

    @Column(name = "has_stable")
    private boolean hasStable;

    @Column(name = "stable_name")
    private String stableName;


    public GeneralUser(String email, String password, String firstName, String lastName, String phone, 
    		String metamask, boolean hasStable, String stableName, UserRole userRole) {
        this.email = email;
		this.password = password; 
		this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.metamask = metamask;
        this.hasStable = hasStable;
        this.stableName = stableName;
        this.userRole = userRole;    
        }

    public GeneralUser() {

    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMetamask(){
        return metamask;
    }

    public void setMetamask(String metamask){
        this.metamask = metamask;
    }

    public boolean getHasStable(){
        return hasStable;
    }

    public void setHasStable(boolean hasStable){
        this.hasStable = hasStable;
    }

    public String getStableName(){
        return stableName;
    }

    public void setStableName(String stableName){
        this.stableName = stableName;
    }
	
}
