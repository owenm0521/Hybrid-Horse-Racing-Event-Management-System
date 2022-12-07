package com.morris.hybridhorseracingeventmanagement.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.morris.hybridhorseracingeventmanagement.service.EventService;

@Entity
@Table(name="registrations")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="eventId")
    private Event event; 
    
    @Column(name="userEmail")
    private String userEmail;
    
    @Column(name="checkedIn")
    private boolean checkedIn;
    
    
    public Registration(String userEmail) {
        this.userEmail = userEmail;
        this.checkedIn = false; 
    }
    
    public Registration() {
    	
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

     
    public Event getEvent() {
        return this.event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
    
    public long getEventId() {
    	return event.getId(); 
    }
    
    public boolean getCheckedIn() {
        return this.checkedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

}

