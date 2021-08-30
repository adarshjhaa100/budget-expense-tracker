package com.tcsc.budgetAndExpense.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"username", "email"}))
public class AppUser {
    private @Id @GeneratedValue Long id;
    // in case we want unique constraint on single column, use @Column(unique = true)
    private String username;
    private String password;
    private String email;
    private String authToken; // reset at each login, logout, 60 minutes

    AppUser(){}

    public AppUser(String username, String password, String email, String authToken) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.authToken = authToken;
    }

    // getters
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getAuthToken() {
        return authToken;
    }

    // setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return Objects.equals(id, appUser.id) && Objects.equals(username, appUser.username) && Objects.equals(password, appUser.password) && Objects.equals(email, appUser.email) && Objects.equals(authToken, appUser.authToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, email, authToken);
    }

    public static String generateAuthToken(){
        String authToken="";
        return authToken;
    }
}
