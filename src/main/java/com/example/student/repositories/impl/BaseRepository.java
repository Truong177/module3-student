package com.example.student.repositories.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    private static String jdbcURL = "jdbc:mysql://localhost:3306/student";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "17072001";
    private static Connection connection = null;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private BaseRepository() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            System.err.println("Failed to establish connection.");
        }
        return connection;
    }
}
