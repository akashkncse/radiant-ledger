package com.akashkn.radiantledger.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    public enum TransactionType {
        DEPOSIT,
        WITHDRAWAL,
        TRANSFER
    }
    private final String transactionId;
    private final String fromAccountId;
    private final BigDecimal amount;
    private final TransactionType type;
    private final String toAccountId;
    private final LocalDateTime timestamp;
    public Transaction(String transactionId, String fromAccountId, BigDecimal amount, TransactionType type, String toAccountId, LocalDateTime timestamp) {
        this.transactionId = transactionId;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
        this.type = type;
        this.timestamp = timestamp;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getFromAccountId() {
        return fromAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }

    public String getToAccountId() {
        return toAccountId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
