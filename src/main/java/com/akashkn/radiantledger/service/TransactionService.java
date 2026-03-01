package com.akashkn.radiantledger.service;

import com.akashkn.radiantledger.dto.TransferRequest;
import com.akashkn.radiantledger.exception.InsufficientFundsException;
import com.akashkn.radiantledger.model.Transaction;
import com.akashkn.radiantledger.repository.TransactionRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class TransactionService {
    TransactionRepository repo;
    public TransactionService(TransactionRepository repo) {
        this.repo = repo;
    }
    public BigDecimal getAccountBalance(String accountId) {
        return repo.getBalance(accountId);
    }
    public void transfer(TransferRequest request)
    {
        BigDecimal balance = repo.getBalance(request.getFromAccountId());
        BigDecimal amount = request.getAmount();
        if (balance.compareTo(amount) < 0) {
            throw new InsufficientFundsException("Account balance is insufficient to make the transfer.");
        } else {
            repo.save(new Transaction(UUID.randomUUID().toString(), request.getFromAccountId(), request.getAmount(), request.getToAccountId(), LocalDateTime.now()));
        }
    }
}
