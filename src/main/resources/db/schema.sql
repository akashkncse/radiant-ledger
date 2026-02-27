CREATE TABLE IF NOT EXISTS account (
    account_id varchar(255) PRIMARY KEY,
    password_hash varchar(255) not null
);

CREATE TABLE IF NOT EXISTS transaction (
    transaction_id varchar(255) PRIMARY KEY,
    from_account_id varchar(255) not null,
    to_account_id varchar(255) not null,
    amount numeric(18, 2) not null default 0.00,
    timestamp timestamp default current_timestamp
);