package com.school.projectschool.util.CRUD;

import com.school.projectschool.util.database.MySqlConnection;
import java.sql.*;
public class ClassResources extends BaseResources {
    public ClassResources() {
        super();
    }

    public void insertMethod(char optionCase) {

        System.out.println("Insert Class mode enabled: ");

        try {
            // Make the first selection to show what the user is seeing.
            String tableOptionCase = valuesOfTable.get(optionCase);
            System.out.println("Class DB contains: ");
            selectMethod(optionCase);
            System.out.println("\n Please insert the new Class' name: ");
            String className = scan.nextLine();
            System.out.println("Assign the Teacher ID now: ");
            int teacherID = Integer.parseInt(scan.nextLine());

            String insertQuery = "INSERT INTO " + tableOptionCase + " (Classname, TeacherId) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, className);
                preparedStatement.setInt(2, teacherID);
                int rowCount = preparedStatement.executeUpdate();
                System.out.println("Updated Rows: " + rowCount);
            }

            System.out.println("\nUpdated Table \n");
            selectMethod(optionCase);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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

    public void updateMethod(char optionCase) {
        System.out.println("Editing Class mode enabled: ");
        // call external class for connecting to DB

        try (Connection connection = MySqlConnection.getConnection()) {
            // performsn first select from to showcase what the user is seeing.
            String query = "SELECT * FROM test";
            System.out.println("Class DB contains: ");
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    System.out.println(resultSet.getString((1)) + ", " + resultSet.getString(2)+ ", " + resultSet.getString(3));

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\n Please insert the ID of the class row to edit: ");
        int classID = Integer.parseInt(scan.nextLine());
        System.out.println("Enter the replacement name for this class: ");
        String className = scan.nextLine();
        System.out.println("Assign the Teacher ID now: ");
        int teacherID = Integer.parseInt(scan.nextLine());
        //String query = "UPDATE test set Classname = " +className+ ", TeacherId " + teacherID + " WHERE id = " + classID +";";

        try
                (Connection connection = MySqlConnection.getConnection()) {
            // Does the UPDATE function
            String query = "UPDATE test SET Classname = '" +className+ "', TeacherId = " + teacherID + " WHERE id = " + classID +";";
            System.out.println(query);
            try (PreparedStatement conn = connection.prepareStatement(query)) {
                int return1 = conn.executeUpdate();
                System.out.println("Updated Rows: " + return1); // returns the number of rows affected
            }
            query = "SELECT * FROM test"; // shows the resulted table
            System.out.println("\nUpdated Table \n");
            try (PreparedStatement conn = connection.prepareStatement(query);
                 ResultSet resultSet = conn.executeQuery()) {
                while (resultSet.next()) {
                    System.out.println(resultSet.getString((1)) + ", " + resultSet.getString(2)+ ", " + resultSet.getString(3));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e); }


    }

    public void deleteMethod(char optionCase) {
        System.out.println("Deleting Class mode enabled: ");
        // call external class for connecting to DB
        try (Connection connection = MySqlConnection.getConnection()) {
            // performsn first select from to showcase what the user is seeing.
            String query = "SELECT * FROM test";
            System.out.println("Class DB contains: ");
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    System.out.println(resultSet.getString((1)) + ", " + resultSet.getString(2)+ ", " + resultSet.getString(3));

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e); }

        System.out.println("\n Please insert the ID of the class row to DELETE: ");
        int classID = Integer.parseInt(scan.nextLine());
        //String query = "DELETE FROM test WHERE id = " + classID +";";

        String query = "DELETE FROM test WHERE id = " + (classID) + ";";
        System.out.println(query + "\n");
        System.out.println("Are you sure you want to delete this class? (Yes/No)\n");
        String AreYouSure = scan.nextLine();
        if (AreYouSure.equals("Yes")) {
            try (Connection connection = MySqlConnection.getConnection()) {
                // Does the DELETE function
                try (PreparedStatement conn = connection.prepareStatement(query)) {
                    int return1 = conn.executeUpdate();
                    System.out.println("Updated Rows: " + return1); // returns the number of rows affected

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            query = "SELECT * FROM test"; // shows the resulted table
            System.out.println("\nUpdated Table \n");
            try (Connection connection = MySqlConnection.getConnection()) {
                try (PreparedStatement conn = connection.prepareStatement(query);
                     ResultSet resultSet = conn.executeQuery()) {
                    while (resultSet.next()) {
                        System.out.println(resultSet.getString((1)) + ", " + resultSet.getString(2) + ", " + resultSet.getString(3));
                    }


                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else { }
    }
}
