package com.akashkn.radiantledger.model;
import java.math.BigDecimal;

public class Account {
    private final String accountId;
    private String passwordHash;
    public Account(String accountId, String passwordHash) {
        this.accountId = accountId;
        this.passwordHash = passwordHash;
    }
    public String getAccountId() {
        return accountId;
    }


    public String getPasswordHash() {
        return passwordHash;
    }


    public void setPassword(String passwordHash)
    {
        this.passwordHash = passwordHash;
    }
}
