package com.akashkn.radiantledger.dto;

public class AccountRegistrationRequest {
    private final String email;
    private final String password;
    public AccountRegistrationRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
