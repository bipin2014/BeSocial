package com.bipin.besocial.domain;

public class AuthResponse {
    private String status;

    public AuthResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
