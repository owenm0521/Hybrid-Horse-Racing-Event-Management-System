package com.morris.hybridhorseracingeventmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="registrations")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="eventId")
    private long eventId;

    @Column(name="userEmail")
    private String userEmail;
    
    @Column(name="checkedIn")
    private boolean checkedIn;

    public Registration(long eventId, String userEmail) {
        this.eventId = eventId;
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

    public long getEventId() {
        return this.eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }
    
    public boolean getCheckedIn() {
        return this.checkedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

}

