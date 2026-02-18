package com.akashkn.radiantledger.model;
import java.math.BigDecimal;

public class Account {
    private final String accountID;
    private String passwordHash;
    private BigDecimal balance;
    public Account(String accountID, BigDecimal balance, String passwordHash) {
        this.accountID = accountID;
        this.balance = balance;
        this.passwordHash = passwordHash;
    }
    public String getAccountID() {
        return accountID;
    }
    public BigDecimal getBalance() {
        return balance;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    public void setPassword(String passwordHash)
    {
        this.passwordHash = passwordHash;
    }
}
