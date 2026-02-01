package com.akashkn.radiantledger.model;
import java.math.BigInteger;

public class Account {
    private final String accountID;
    private String password;
    private BigInteger balance;

    public Account(String accountID, BigInteger balance, String password) {
        this.accountID = accountID;
        this.balance = balance;
        this.password = password;
    }

    public String getAccountID() {
        return accountID;
    }

    public BigInteger getBalance() {
        return balance;
    }

}
