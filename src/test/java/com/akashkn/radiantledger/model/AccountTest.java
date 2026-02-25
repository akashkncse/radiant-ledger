package com.akashkn.radiantledger.model;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    @Test
    void testAccountInitialization() {
        String id = "ACC";
        String pw_hash = "hashedpw";

        Account account = new Account(id, pw_hash);

        assertEquals(id, account.getAccountID());
        assertEquals(pw_hash, account.getPasswordHash());
    }

    @Test
    void testSetPassword() {
        Account account = new Account("1", "pw_hash");
        String new_pw_hash = "pw_hash_new";

        account.setPassword(new_pw_hash);

        assertEquals(new_pw_hash, account.getPasswordHash());
    }
}