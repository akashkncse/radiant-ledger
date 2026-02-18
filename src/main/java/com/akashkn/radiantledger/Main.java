package com.akashkn.radiantledger;
import com.akashkn.radiantledger.db.DatabaseManager;
import com.akashkn.radiantledger.model.Account;
import com.akashkn.radiantledger.repository.AccountRepository;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        DatabaseManager db = new DatabaseManager();
        AccountRepository accRepo = new AccountRepository(db);
        Account acc = new Account("1", new BigDecimal("1000.83"), "yeah");
        accRepo.save(acc);
    }
}