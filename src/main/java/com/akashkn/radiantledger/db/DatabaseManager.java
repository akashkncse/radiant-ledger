package com.akashkn.radiantledger.db;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class DatabaseManager {
    private final String DB_URL;
    private final String DB_USER;
    private final String DB_PASSWORD;
    public DatabaseManager(String DB_URL, String DB_USER, String DB_PASSWORD)
    {
        this.DB_URL = DB_URL;
        this.DB_USER = DB_USER;
        this.DB_PASSWORD = DB_PASSWORD;
    }
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
