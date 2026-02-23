package com.akashkn.radiantledger.repository;

import com.akashkn.radiantledger.db.DatabaseManager;
import com.akashkn.radiantledger.model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.math.BigDecimal;

public class AccountRepository {
    private final DatabaseManager db;
    public AccountRepository(DatabaseManager db)
    {
        this.db = db;
    }

    public void save(Account account) {
        //language=PostgreSQL
        String sql = "INSERT INTO account (account_id, password_hash, balance) VALUES (?, ?, ?)";
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

    private Account mapRowToAccount(ResultSet rs) throws SQLException {
        Account ac = new Account(rs.getString("account_id"),
                new BigDecimal(rs.getString("balance")),
                rs.getString("password_hash"));
        return ac;
    }

    public Optional<Account> findByID(String accountID) {
        //language=PostgreSQL
        String sql = "SELECT * FROM account WHERE account_id = ?";
        try (Connection conn = db.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, accountID);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapRowToAccount(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }
}
