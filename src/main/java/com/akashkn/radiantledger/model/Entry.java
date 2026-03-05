package com.akashkn.radiantledger.model;

import java.math.BigDecimal;
import java.util.Map;

public class Entry {
    private final long entryId;
    private final long accountId;
    private final long journalId;
    private final BigDecimal amount;
    private final String assetCode;
    private final Map<String, Object> metadata;

    public Entry(long entryId,
                 long accountId,
                 long journalId,
                 BigDecimal amount,
                 String assetCode,
                 Map<String, Object> metadata) {
        this.entryId = entryId;
        this.accountId = accountId;
        this.journalId = journalId;
        this.amount = amount;
        this.assetCode = assetCode;
        this.metadata = metadata;
    }
    public long getEntryId() {
        return entryId;
    }
    public long getAccountId() {
        return accountId;
    }
    public long getJournalId() {
        return journalId;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public String getAssetCode() {
        return assetCode;
    }
    public Map<String, Object> getMetadata() {
        return metadata;
    }
}
