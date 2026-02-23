package com.akashkn.radiantledger;
import com.akashkn.radiantledger.db.DatabaseManager;
import com.akashkn.radiantledger.model.Account;
import com.akashkn.radiantledger.repository.AccountRepository;

import java.math.BigDecimal;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        DatabaseManager db = new DatabaseManager("jdbc:postgresql://localhost:5432/radiantledger", "postgres", "123");
        AccountRepository accRepo = new AccountRepository(db);
        Optional<Account> ac = accRepo.findByID("1");
        System.out.println(ac.get().getBalance());
    }
}