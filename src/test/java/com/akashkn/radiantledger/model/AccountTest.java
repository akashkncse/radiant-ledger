package com.akashkn.radiantledger.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    @Test
    void testAccountInitialization() {
        String id = "ACC";
        BigDecimal initialBalance = new BigDecimal("100.34");
        String pw_hash = "hashedpw";

        Account account = new Account(id, initialBalance, pw_hash);

        assertEquals(id, account.getAccountID());
        assertEquals(initialBalance, account.getBalance());
        assertEquals(pw_hash, account.getPasswordHash());
    }

    @Test
    void testSetBalance() {
        Account account = new Account("1", BigDecimal.ZERO, "pw_hash");
        BigDecimal newBalance = new BigDecimal("500.00");

        account.setBalance(newBalance);

        assertEquals(newBalance, account.getBalance());
    }

    @Test
    void testSetPassword() {
        Account account = new Account("1", BigDecimal.ZERO, "pw_hash");
        String new_pw_hash = "pw_hash_new";

        account.setPassword(new_pw_hash);

        assertEquals(new_pw_hash, account.getPasswordHash());
    }
}