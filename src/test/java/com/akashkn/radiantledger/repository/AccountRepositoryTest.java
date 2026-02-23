package com.akashkn.radiantledger.repository;

import com.akashkn.radiantledger.db.DatabaseManager;
import com.akashkn.radiantledger.model.Account;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AccountRepositoryTest {

    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine").withInitScript("db/schema.sql");

    AccountRepository accountRepository;

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
    }

    @Test
    void testFindByID()
    {
        accountRepository.save(new Account("A1", new BigDecimal("10.23"), "lsdjf"));
        accountRepository.save(new Account("B2", new BigDecimal("12.23"), "dsfsdfsdf"));

        Optional<Account> acc = accountRepository.findByID("B2");
        assertEquals("B2", acc.get().getAccountID());
    }

}