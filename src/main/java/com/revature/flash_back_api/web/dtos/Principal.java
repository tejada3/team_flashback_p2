package com.revature.flash_back_api.web.dtos;

<<<<<<< HEAD
import com.revature.flash_back_api.models.documents.Users;

import java.util.Objects;

=======

import io.jsonwebtoken.Claims;

import java.util.Objects;

// This is a regular POJO and does not need to be initialized via Spring

public class Principal {
    private String id;
    private String username;
    private String role;

    public Principal() { super(); }


    public Principal(Users subject) {
        this.id = subject.getUserId();
        this.username = subject.getUsername();
    }

//    Principal(Claims jwtClaims) {
//        this.id = jwtClaims.getId();
//        this.username = jwtClaims.getSubject();
//    }


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
        if (o == null || getClass() != o.getClass()) return false;
        Principal principal = (Principal) o;
        return Objects.equals(id, principal.id) && Objects.equals(username, principal.username) && Objects.equals(role, principal.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, role);
    }

    @Override
    public String toString() {
        return "Principal{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                '}';
    }


}
