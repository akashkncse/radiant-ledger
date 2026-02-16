package com.akashkn.radiantledger;
import com.akashkn.radiantledger.db.DatabaseManager;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DatabaseManager.getConnection()) {
            System.out.println("Connected!");
        } catch (SQLException e) {
            throw new RuntimeException("Failed to connect to database", e);
        }
    }
}