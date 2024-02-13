package com.school.projectschool.util.database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySqlConnection {
    private static final String JDBC_URL;
    private static final String USER;
    private static final String PASSWORD;

    static {
        Properties properties = new Properties();
        try (InputStream input = MySqlConnection.class.getClassLoader().getResourceAsStream("database.properties")) {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Error loading database properties", e);
        }

        JDBC_URL = properties.getProperty("jdbc.url");
        USER = properties.getProperty("db.user");
        PASSWORD = properties.getProperty("db.password");
    }

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error connecting to the database", e);
        }
    }
}
