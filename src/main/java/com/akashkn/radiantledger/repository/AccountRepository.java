package com.akashkn.radiantledger.repository;

import com.akashkn.radiantledger.db.DatabaseManager;
import com.akashkn.radiantledger.model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountRepository {
    private final DatabaseManager db;
    public AccountRepository(DatabaseManager db)
    {
        this.db = db;
    }

    public void save(Account account) throws SQLException {
        //language=PostgreSQL
        String sql = "INSERT INTO account (accountid, password_hash, balance) VALUES (?, ?, ?)";

        try (Connection conn = db.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, account.getAccountID());
            pstmt.setString(2, account.getPasswordHash());
            pstmt.setBigDecimal(3, account.getBalance());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
