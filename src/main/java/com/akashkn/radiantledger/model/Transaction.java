package com.akashkn.radiantledger.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    private final String transactionID;
    private final String fromAccountID;
    private final BigDecimal amount;
    private final String type;
    private final String toAccountID;
    private final LocalDateTime timestamp;
    public Transaction(String transactionID, String fromAccountID, BigDecimal amount, String type, String toAccountID, LocalDateTime timestamp) {
        this.transactionID = transactionID;
        this.fromAccountID = fromAccountID;
        this.toAccountID = toAccountID;
        this.amount = amount;
        this.type = type;
        this.timestamp = timestamp;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public String getFromAccountID() {
        return fromAccountID;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public String getToAccountID() {
        return toAccountID;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
