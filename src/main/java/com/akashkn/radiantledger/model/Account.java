package com.akashkn.radiantledger.model;
import java.math.BigDecimal;

public class Account {
    private final String accountID;
    private String password;
    private BigDecimal balance;
    public Account(String accountID, BigDecimal balance, String password) {
        this.accountID = accountID;
        this.balance = balance;
        this.password = password;
    }
    public String getAccountID() {
        return accountID;
    }
    public BigDecimal getBalance() {
        return balance;
    }
}
