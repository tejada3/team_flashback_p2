package com.revature.flash_back_api.models.documents;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;



@Scope("prototype")
@Component
public class Users {

    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private String role;
    private int totalScore  = 0;
    private LocalDateTime registrationDateTime;

    public Users(){
    super();
    };


    Users(String firstName, String lastName, String email, String username, String password, String role, LocalDateTime registrationDateTime){
        this.firstName = firstName;
        this.lastName =  lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
        this.registrationDateTime = registrationDateTime;
    }

    // #TODO update getters/setters, equals, toString, hashCode


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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
        return getTotalScore() == users.getTotalScore() && getUserId().equals(users.getUserId()) && getFirstName().equals(users.getFirstName()) && getLastName().equals(users.getLastName()) && getEmail().equals(users.getEmail()) && getUsername().equals(users.getUsername()) && getPassword().equals(users.getPassword()) && Objects.equals(getRole(), users.getRole()) && Objects.equals(registrationDateTime, users.registrationDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getFirstName(), getLastName(), getEmail(), getUsername(), getPassword(), getRole(), getTotalScore(), registrationDateTime);
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId='" + userId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", totalScore=" + totalScore +
                ", registrationDateTime=" + registrationDateTime +
                '}';
    }
}

