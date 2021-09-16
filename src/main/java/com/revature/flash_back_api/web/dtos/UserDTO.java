package com.revature.flash_back_api.web.dtos;

import com.revature.flash_back_api.models.documents.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class UserDTO {


    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String role;
    private int totalScore;
    private LocalDate registrationDateTime;


    public UserDTO(User user){
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.username = user.getUsername();
        this.role = user.getRole();
        this.totalScore = user.getTotalScore();
        this.registrationDateTime = user.getRegistrationDateTime();
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

    public void getId(String id) {
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
        if (!(o instanceof UserDTO)) return false;
        UserDTO userDTO = (UserDTO) o;
        return getTotalScore() == userDTO.getTotalScore() && getId().equals(userDTO.getId()) && getFirstName().equals(userDTO.getFirstName()) && getLastName().equals(userDTO.getLastName()) && getEmail().equals(userDTO.getEmail()) && getUsername().equals(userDTO.getUsername()) && getRole().equals(userDTO.getRole()) && getRegistrationDateTime().equals(userDTO.getRegistrationDateTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getEmail(), getUsername(), getRole(), getTotalScore(), getRegistrationDateTime());
    }


    @Override
    public String toString() {
        return "UserDTO{" +
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
