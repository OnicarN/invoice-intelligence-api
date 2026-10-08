package com.invoiceai.domain.model;

import java.util.UUID;

public class User{
    
    private UUID id; 
    private String password; 
    private String email;
    
    public User(UUID id, String password, String email) {
        this.id = id;
        this.password = password;
        this.email = email;
    }

    
    public User() {
    }



    public UUID getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}