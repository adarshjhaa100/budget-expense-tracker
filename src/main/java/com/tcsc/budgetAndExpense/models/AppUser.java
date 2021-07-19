package com.tcsc.budgetAndExpense.models;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

// Entity for user class for authenticating and authorizing

@Entity
public class AppUser {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private String email;
    private String authToken;   // auto generated when user logs in
    private boolean tokenSet;   // is token set or not(we may unset token after some duration)

    AppUser(){}

    public AppUser(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.authToken="";
        this.tokenSet=false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public boolean isTokenSet() {
        return tokenSet;
    }

    public void setTokenSet(boolean tokenSet) {
        this.tokenSet = tokenSet;
    }

    // token generation when user logs in
    public void generateToken(){
        this.authToken= UUID.randomUUID().toString();
        this.tokenSet=true;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Map<String,Object> addUserResponse(){
        Map<String,Object> map=new HashMap<>();
        map.put("username",this.username);
        map.put("id",this.id);
        map.put("status","successfully added user");
        return map;
    }
}
