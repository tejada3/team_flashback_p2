package com.revature.flash_back_api.models.documents;

import org.apache.tomcat.jni.Local;
import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.Objects;



@Scope("prototype")
@Component
@Document(collection = "users")
public class User {


    private String id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @Email
    private String email;

    @Length(min = 5, max = 15)
    private String username;

    //TODO add constraints to password field here
    private String password;

    private String role;
    private int totalScore;


    private LocalDate registrationDateTime;

    public User(){
    super();
    };

    public User(String firstName, String lastName, String email, String username, String password){
        this.firstName = firstName;
        this.lastName =  lastName;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public User(String firstName, String lastName, String email, String username, String password, String role){
        this(firstName, lastName, email, username, password);
        this.role = role;
    }

    public User(String firstName, String lastName, String email, String username, String password, String role, LocalDateTime registrationDateTime){
        this(firstName, lastName, email, username, password, role);

    }


    public LocalDate getRegistrationDateTime() {
        return registrationDateTime;
    }

    public void setRegistrationDateTime(LocalDate registrationDateTime) {
        this.registrationDateTime = registrationDateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String userId) {
        this.id = id;
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
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getTotalScore() == user.getTotalScore() && getId().equals(user.getId()) && getFirstName().equals(user.getFirstName()) && getLastName().equals(user.getLastName()) && getEmail().equals(user.getEmail()) && getUsername().equals(user.getUsername()) && getPassword().equals(user.getPassword()) && Objects.equals(getRole(), user.getRole()) && Objects.equals(registrationDateTime, user.registrationDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getEmail(), getUsername(), getPassword(), getRole(), getTotalScore(), registrationDateTime);
    }

    @Override
    public String toString() {
        return "Users{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", totalScore=" + totalScore +
                ", registrationDateTime=" + registrationDateTime +
                '}';
    }
}

