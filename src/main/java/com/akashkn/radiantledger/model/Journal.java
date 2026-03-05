package com.akashkn.radiantledger.model;

import java.time.OffsetDateTime;
import java.util.Map;

public class Journal {
    private final long journalId;
    private final OffsetDateTime createdAt;
    private String description;
    private Map<String, Object> metadata;

    public Journal(long journalId,
                   OffsetDateTime createdAt,
                   String description,
                   Map<String, Object> metadata) {
        this.journalId = journalId;
        this.createdAt = createdAt;
        this.description = description;
        this.metadata = (metadata != null) ? Map.copyOf(metadata) : Map.of();
    }

    public long getJournalId() {
        return journalId;
    }
    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }
    public String getDescription() {
        return description;
    }
    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }
}
