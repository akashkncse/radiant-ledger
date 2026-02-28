package com.akashkn.radiantledger.service;

import com.akashkn.radiantledger.model.Transaction;
import com.akashkn.radiantledger.repository.TransactionRepository;

import java.math.BigDecimal;
import java.util.List;

public class TransactionService {
    TransactionRepository repo;
    public TransactionService(TransactionRepository repo) {
        this.repo = repo;
    }
    public BigDecimal getAccountBalance(String accountId)
    {
        return repo.getBalance(accountId);
    }
}
