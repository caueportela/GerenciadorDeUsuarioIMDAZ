package edu.projeto.integrador.imdaz.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PostgresConnector {
    private Connection conn = null;
    private static PostgresConnector instance = null;

    private PostgresConnector() throws SQLException {
        this.conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/IMDAZ", "postgres", "250682");

    }

    public static PostgresConnector getInstance() {
        if (instance == null) {
            try {
                instance = new PostgresConnector();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return instance;
    }

    public static void close() {
        if (instance != null) {
            try {
                instance.conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public PreparedStatement getPreparedStatement(String sql) throws SQLException {
        return this.conn.prepareStatement(sql);
    }
}
