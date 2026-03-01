package com.akashkn.radiantledger.dto;

import java.math.BigDecimal;

public class TransferRequest {
    private final String fromAccountId;
    private final String toAccountId;
    private final BigDecimal amount;

    public TransferRequest(String fromAccountId, String toAccountId, BigDecimal amount) {
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
    }

    public String getFromAccountId() {
        return fromAccountId;
    }

    public String getToAccountId() {
        return toAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
