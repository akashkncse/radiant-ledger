package com.akashkn.radiantledger.service;

import com.akashkn.radiantledger.db.DatabaseManager;
import com.akashkn.radiantledger.dto.AccountRegistrationRequest;
import com.akashkn.radiantledger.repository.AccountRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine").withInitScript("db/schema.sql");

    AccountRepository accountRepository;
    AccountService accountService;
    PasswordService passwordService = new PasswordService();
    @BeforeAll
    static void beforeAll() {
        postgres.start();
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();
    }

    @BeforeEach
    void setUp()
    {
        DatabaseManager db = new DatabaseManager(
                postgres.getJdbcUrl(),
                postgres.getUsername(),
                postgres.getPassword()
        );
        accountRepository = new AccountRepository(db);
        accountService = new AccountService(accountRepository, passwordService);
    }

    @Test
    void testCreateAccount()
    {
        AccountRegistrationRequest request = new AccountRegistrationRequest("akash@supersecretwebsite.com", "hiiamakash");
        accountService.createAccount(request);
        assertEquals(accountRepository.findById("akash@supersecretwebsite.com").get().getAccountId(), "akash@supersecretwebsite.com");
    }
}