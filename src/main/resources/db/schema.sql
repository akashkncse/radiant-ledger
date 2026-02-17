CREATE TABLE IF NOT EXISTS account (
    accountID varchar(255) PRIMARY KEY,
    passwordHash varchar(255) not null,
    balance numeric(18, 2) not null default 0.00
);

CREATE TABLE IF NOT EXISTS transaction (
    transactionID varchar(255) PRIMARY KEY,
    fromAccountID varchar(255) not null,
    toAccountID varchar(255) not null,
    amount numeric(18, 2) not null default 0.00,
    type varchar(255) not null,
    timestamp timestamp default current_timestamp
)