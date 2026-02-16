package com.akashkn.radiantledger.db;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/radiantledger";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "123";
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
