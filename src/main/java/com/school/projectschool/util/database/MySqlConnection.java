package com.school.projectschool.util.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
    private static final String JDBC_URL = "jdbc:mysql://aws.connect.psdb.cloud/cctbmanagement?sslMode=VERIFY_IDENTITY";
    private static final String USER = "cdv66852cgpdfnwt06yk";
    private static final String PASSWORD = "pscale_pw_S4CZlp9imalLmNG0oxjh3yZBe2YCLVZqNF6yMt9FKeM";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error connection database", e);
        }
    }
}
