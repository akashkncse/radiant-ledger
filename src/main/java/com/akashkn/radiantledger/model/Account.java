package com.akashkn.radiantledger.model;
import java.math.BigDecimal;

public class Account {
    private final String accountID;
    private String passwordHash;
    public Account(String accountID, String passwordHash) {
        this.accountID = accountID;
        this.passwordHash = passwordHash;
    }
    public String getAccountID() {
        return accountID;
    }


    public String getPasswordHash() {
        return passwordHash;
    }


    public void setPassword(String passwordHash)
    {
        this.passwordHash = passwordHash;
    }
}
