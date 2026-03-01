package com.akashkn.radiantledger.service;

import com.akashkn.radiantledger.db.DatabaseManager;
import com.akashkn.radiantledger.dto.TransferRequest;
import com.akashkn.radiantledger.model.Transaction;
import com.akashkn.radiantledger.repository.AccountRepository;
import com.akashkn.radiantledger.repository.TransactionRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TransactionServiceTest {
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine").withInitScript("db/schema.sql");
    TransactionService transactionService;
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
    void setUp() {
        DatabaseManager db = new DatabaseManager(
                postgres.getJdbcUrl(),
                postgres.getUsername(),
                postgres.getPassword()
        );
        transactionRepository = new TransactionRepository(db);
        transactionService = new TransactionService(transactionRepository);
    }

    @Test
    void testTransfer(){
        Transaction tx = new Transaction("example", "ac3", new BigDecimal(10000), "ac1", LocalDateTime.now());
        TransferRequest request = new TransferRequest("ac1", "ac2", new BigDecimal("1000"));

        transactionRepository.save(tx);
        transactionService.transfer(request);

        assertEquals(new BigDecimal("9000.00"), transactionService.getAccountBalance("ac1"));
        assertEquals(new BigDecimal("1000.00"), transactionService.getAccountBalance("ac2"));
    }
}