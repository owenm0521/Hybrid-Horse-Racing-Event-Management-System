package com.morris.hybridhorseracingeventmanagement.model;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.*;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dateTime;
    
    @Column(name="description")
    private String description;

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

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
