CREATE TABLE IF NOT EXISTS account (
                                       account_id BIGSERIAL PRIMARY KEY,
                                       metadata JSONB
);

CREATE TABLE IF NOT EXISTS journal (
                                       journal_id BIGSERIAL PRIMARY KEY,
                                       created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
                                       description TEXT,
                                       metadata JSONB
);

CREATE TABLE IF NOT EXISTS entry (
                                     entry_id BIGSERIAL PRIMARY KEY,
                                     account_id INT NOT NULL REFERENCES account(account_id),
                                     journal_id INT NOT NULL REFERENCES journal(journal_id),
                                     amount NUMERIC(19, 4) NOT NULL,
                                     asset_code VARCHAR(10) NOT NULL,
                                     metadata JSONB
);

CREATE INDEX index_entry_account_asset ON entry(account_id, asset_code);