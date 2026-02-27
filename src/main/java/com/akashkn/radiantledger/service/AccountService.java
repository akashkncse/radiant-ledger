package com.akashkn.radiantledger.service;

import com.akashkn.radiantledger.dto.AccountRegistrationRequest;
import com.akashkn.radiantledger.exception.InvalidEmailException;
import com.akashkn.radiantledger.model.Account;
import org.apache.commons.validator.EmailValidator;
import com.akashkn.radiantledger.repository.AccountRepository;

import java.util.Optional;

public class AccountService {
    private final AccountRepository repo;
    private final PasswordService ps;
    public AccountService(AccountRepository repo, PasswordService ps) {
        this.repo = repo;
        this.ps = ps;
    }
    public void createAccount(AccountRegistrationRequest request) {
        // validate accountId;
        if (!EmailValidator.getInstance().isValid(request.getEmail()))
            throw new InvalidEmailException("Email not valid!");
        if (repo.findById(request.getEmail()).isPresent()) throw new RuntimeException("Account already exists!");
        Account ac = new Account(request.getEmail(), ps.hashPassword(request.getPassword()));
        repo.save(ac);
    }
}
