package com.morris.hybridhorseracingeventmanagement.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long id;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "metamask")
    private String metamask;

    @Column(name = "has_table")
    private boolean hasStable;

    @Column(name = "stable_name")
    private String stableName;


    public User(String email, String password, String firstName, String lastName,
                String phone, String metamask, boolean hasStable, String stableName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.metamask = metamask;
        this.hasStable = hasStable;
        this.stableName = stableName;
    }

    public User() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
