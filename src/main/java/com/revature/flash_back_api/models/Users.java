package com.revature.flash_back_api.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;



@Scope("prototype")
@Component
public class Users {


    private ObjectMapper mapper;


    @Autowired
    public Users(ObjectMapper mapper) {
        this.mapper = mapper;
    }



    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private String roles;
    int totalScore  = 0;


    public Users(){
    super();
    };


    Users(String firstName, String lastName, String email, String username, String password, ObjectMapper mapper){
        this.firstName = firstName;
        this.lastName =  lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.mapper = mapper;


    }



    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        Users users = (Users) o;
        return getTotalScore() == users.getTotalScore() && getUserId().equals(users.getUserId()) && getFirstName().equals(users.getFirstName()) && getLastName().equals(users.getLastName()) && getEmail().equals(users.getEmail()) && getUsername().equals(users.getUsername()) && getPassword().equals(users.getPassword()) && getRoles().equals(users.getRoles());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getFirstName(), getLastName(), getEmail(), getUsername(), getPassword(), getRoles(), getTotalScore());
    }




}

