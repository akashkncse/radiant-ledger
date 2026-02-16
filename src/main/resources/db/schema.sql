CREATE TABLE account (
    accountID varchar(255) PRIMARY KEY,
    password_hash varchar(255) not null,
    balance numeric(18, 2) not null default 0.00
);