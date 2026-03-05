package com.akashkn.radiantledger.model;

import java.util.Map;

public class Account {
    private long accountId;
    private Map<String, Object> metadata;
    public Account(long accountId,
                   Map<String, Object> metadata) {
        this.accountId = accountId;
        this.metadata = metadata;
    }
    public Account(Map<String, Object> metadata) {
        this.metadata = metadata;
    }
    public long getAccountId() {
        return accountId;
    }
    public Map<String, Object> getMetadata() {
        return metadata;
    }
    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }
}
