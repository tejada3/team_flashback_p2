package com.revature.flash_back_api.web.dtos;


import com.revature.flash_back_api.models.documents.User;
import java.util.Objects;
import io.jsonwebtoken.Claims;

// This is a regular POJO and does not need to be initialized via Spring

public class Principal {
    private String id;
    private String username;
    private String role;
    private String firstName;
    private String lastName;
    private String email;
    private int totalScore;

    public Principal() { super(); }

    public Principal(User subject) {
        this.id = subject.getId();
        this.username = subject.getUsername();
        this.role = subject.getRole();
        this.firstName = subject.getFirstName();
        this.lastName = subject.getLastName();
        this.email = subject.getEmail();
        this.totalScore = subject.getTotalScore();
    }

    public Principal(Claims jwtClaims) {
        this.id = jwtClaims.getId();
        this.username = jwtClaims.getSubject();
        this.role = jwtClaims.get("role", String.class);
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

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Principal)) return false;
        Principal principal = (Principal) o;
        return getTotalScore() == principal.getTotalScore() && Objects.equals(getId(), principal.getId()) && Objects.equals(getUsername(), principal.getUsername()) && Objects.equals(getRole(), principal.getRole()) && Objects.equals(getFirstName(), principal.getFirstName()) && Objects.equals(getLastName(), principal.getLastName()) && Objects.equals(getEmail(), principal.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getRole(), getFirstName(), getLastName(), getEmail(), getTotalScore());
    }


    @Override
    public String toString() {
        return "Principal{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", totalScore=" + totalScore +
                '}';
    }
}
