package com.school.projectschool.util.CRUD;

import com.school.projectschool.util.MappingValues;
import com.school.projectschool.util.database.MySqlConnection;

import java.sql.*;
import java.util.Map;
import java.util.Scanner;

public abstract class BaseResources implements CRUDoperations {
    protected final Connection connection;
    public final Map<Character, String> valuesOfTable;
    protected final Scanner scan;

    public BaseResources() {
        this.connection = MySqlConnection.getConnection();
        this.valuesOfTable = new MappingValues().tablesSchool();
        this.scan = new Scanner(System.in);
    }

    public void selectMethod(char optionCase) {
        try {
            String tableOptionCase = valuesOfTable.get(optionCase);
            String query = "SELECT * FROM " + tableOptionCase;

            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();

                // Print column names
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(metaData.getColumnName(i) + "\t");
                }
                System.out.println();

                // Print values of columns
                while (resultSet.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.print(resultSet.getString(i) + "\t");
                    }
                    System.out.println();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
