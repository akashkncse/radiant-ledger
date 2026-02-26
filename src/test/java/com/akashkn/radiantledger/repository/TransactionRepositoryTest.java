package com.akashkn.radiantledger.repository;

import com.akashkn.radiantledger.db.DatabaseManager;
import com.akashkn.radiantledger.model.Account;
import com.akashkn.radiantledger.model.Transaction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransactionRepositoryTest {

    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine").withInitScript("db/schema.sql");

    AccountRepository accountRepository;
    TransactionRepository transactionRepository;


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
        transactionRepository = new TransactionRepository(db);
        accountRepository = new AccountRepository(db);
    }

    @Test
    void testFindTxByAccountId()
    {
        accountRepository.save(new Account("ac1", "lsdjf"));
        accountRepository.save(new Account("ac2", "dsfsdfsdf"));

        Transaction tx1 = new Transaction("tx1", "ac1", new BigDecimal("10.23"), Transaction.TransactionType.DEPOSIT, "ac2", LocalDateTime.now());
        Transaction tx2 = new Transaction("tx2", "ac2", new BigDecimal("10.23"), Transaction.TransactionType.DEPOSIT, "ac1", LocalDateTime.now());

        transactionRepository.save(tx1);
        transactionRepository.save(tx2);

        List<Transaction> result = transactionRepository.findByAccountId("ac1");
        assertEquals(result.get(0).getTransactionId(), tx1.getTransactionId());
        assertEquals(result.get(1).getTransactionId(), tx2.getTransactionId());
    }


}