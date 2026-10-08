package com.invoiceai.presentation.dto;

import java.util.UUID;

public class UserResponse {

    private UUID id;
    private String email;

    public UserResponse(UUID id, String email) {
        this.id = id;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}