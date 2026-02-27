package com.akashkn.radiantledger.repository;

import com.akashkn.radiantledger.db.DatabaseManager;
import com.akashkn.radiantledger.model.Transaction;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {
    private final DatabaseManager db;
    public TransactionRepository(DatabaseManager db)
    {
        this.db = db;
    }

    public void save(Transaction tx)
    {
        //language=PostgreSQL
        String sql = "INSERT INTO transaction " +
                "(transaction_id, from_account_id, to_account_id," +
                " amount, timestamp) " +
                "values (?, ?, ?, ?, ?)";

        try (Connection conn = db.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tx.getTransactionId());
            pstmt.setString(2, tx.getFromAccountId());
            pstmt.setString(3, tx.getToAccountId());
            pstmt.setBigDecimal(4, tx.getAmount());
            pstmt.setObject(6, tx.getTimestamp());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Transaction mapRowToTransaction(ResultSet rs) throws SQLException{
        Transaction tx = new Transaction(rs.getString("transaction_id"),
                rs.getString("from_account_id"),
                rs.getBigDecimal("amount"),
                rs.getString("to_account_id"),
                rs.getTimestamp("timestamp").toLocalDateTime());
        return tx;
    }

    public List<Transaction> findByAccountId(String accountId)
    {
        List<Transaction> transactions = new ArrayList<Transaction>();

        //language=PostgreSQL
        String sql = "SELECT * FROM transaction " +
                "WHERE from_account_id = ? OR to_account_id = ? " +
                "ORDER BY timestamp DESC";

        try (Connection conn = db.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, accountId);
            pstmt.setString(2, accountId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next())
            {
                Transaction tx = mapRowToTransaction(rs);
                transactions.add(tx);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return transactions;
    }
}
