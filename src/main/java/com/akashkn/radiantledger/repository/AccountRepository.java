package com.akashkn.radiantledger.repository;

import com.akashkn.radiantledger.db.DatabaseManager;
import com.akashkn.radiantledger.model.Account;
import org.postgresql.util.PGobject;
import tools.jackson.databind.ObjectMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Optional;

public class AccountRepository {
    private final DatabaseManager db;
    public AccountRepository(DatabaseManager db)
    {
        this.db = db;
    }

    public void save(Account account) throws SQLException {
        Map<String, Object> metadata = account.getMetadata();
        ObjectMapper mapper = new ObjectMapper();
        String metadataJson = mapper.writeValueAsString(metadata);
        PGobject jsonObject = new PGobject();
        jsonObject.setType("JSONB");
        jsonObject.setValue(metadataJson);
        //language=PostgreSQL
        String sql = "INSERT INTO account (metadata) VALUES (?)";
        try (Connection conn = db.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setObject(1, jsonObject);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    private Account mapRowToAccount(ResultSet rs) throws SQLException {
//        Account ac = new Account(rs.getString("account_id"),
//                rs.getString("password_hash"));
//        return ac;
//    }
//
//    public Optional<Account> findById(String accountId) {
//        //language=PostgreSQL
//        String sql = "SELECT * FROM account WHERE account_id = ?";
//        try (Connection conn = db.getConnection();
//            PreparedStatement pstmt = conn.prepareStatement(sql)) {
//
//            pstmt.setString(1, accountId);
//            try (ResultSet rs = pstmt.executeQuery()) {
//                if (rs.next()) {
//                    return Optional.of(mapRowToAccount(rs));
//                }
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return Optional.empty();
//    }
}
