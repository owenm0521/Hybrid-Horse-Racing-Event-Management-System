package com.morris.hybridhorseracingeventmanagement.model;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Entity
@Table(name="events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="location")
    private String location;

    @Column(name="date_time")
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dateTime;
    
    @Column(name="description")
    private String description;
    
    @JsonManagedReference
    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.REMOVE, mappedBy="event")
    List<Registration> registrations; 
     

    public Event(String name, String location, LocalDateTime dateTime, String description) {
        this.name = name;
        this.location = location;
        this.dateTime = dateTime; 
        this.description = description; 
    }

    public Event() {
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
    
    /*
     * @param length - "short" returns abbreviated month, "long" returns full month 
     */
    public String getMonth(String length) {
    	if(length.equals("short")){
    		return dateTime.getMonth().getDisplayName(TextStyle.SHORT, Locale.US).toUpperCase(); 
    	}
    	return Character.toString(Character.toUpperCase(dateTime.getMonth().toString().charAt(0))) + dateTime.getMonth().toString().substring(1).toLowerCase(); 
    }
    
    public String getDayOfWeek() {
    	return Character.toString(Character.toUpperCase(dateTime.getDayOfWeek().toString().charAt(0))) + dateTime.getDayOfWeek().toString().substring(1).toLowerCase(); 
    }
    
    public String getTime() {
    	int hour = dateTime.getHour(); 
    	boolean am = true; 
    	if(hour == 0) {
    		hour = 12; 
    	}else if(hour == 12) {
    		am = false; 
    	}else if(hour > 12){
        	hour -= 12; 
        	am = false; 
    	}
    	
    	String minute; 
    	if(dateTime.getMinute() < 10) {
    		minute = "0" + Integer.toString(dateTime.getMinute()); 
    	}else {
    		minute = Integer.toString(dateTime.getMinute()); 
    	}
    	if(am) {
    		return hour + ":" + minute + " AM"; 
    	}
    	return hour + ":" + minute + " PM"; 
    }
    	
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public void addRegistration(Registration registration) {
        if(registrations == null) registrations = new ArrayList<Registration>();
        registration.setEvent(this);
        registrations.add(registration);
    }
    
    public List<Registration> getRegistrations(){
    	return registrations; 
    }

}
