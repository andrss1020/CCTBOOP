package com.school.projectschool.util.CRUD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentsResources extends BaseResources {

    public StudentsResources() {
        super();
    }

    public void insertMethod(char optionCase) {
        System.out.println("Insert Student mode enabled: ");

        try {
            String tableOptionCase = valuesOfTable.get(optionCase);
            System.out.println("Student DB contains: ");

            selectMethod(optionCase);

//            System.out.println("\nPlease insert the new Student's ID: ");
            int StudentID = getNextId(optionCase);

            System.out.println("Assign the Student's name: ");
            String StudentName = scan.nextLine();

            String insertQuery = "INSERT INTO " + tableOptionCase + " (StudentID, StudentName) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setInt(1, StudentID);
                preparedStatement.setString(2, StudentName);

                int rowCount = preparedStatement.executeUpdate();
                System.out.println("Updated Rows: " + rowCount);
            }

            System.out.println("\nUpdated Table \n");
            selectMethod(optionCase);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateMethod(char optionCase) {
        System.out.println("Editing Student enabled: ");

        try {
            String tableOptionCase = valuesOfTable.get(optionCase);
            System.out.println("Student DB contains: ");

            selectMethod(optionCase);

            System.out.println("\nPlease insert the ID of the Student row to edit: ");
            int StudentID = Integer.parseInt(scan.nextLine());

            System.out.println("Enter the new Student ID: ");
            System.out.println("Assign the new name: ");
            String StudentName = scan.nextLine();

            String updateQuery = "UPDATE " + tableOptionCase + " SET StudentName = ? WHERE StudentID = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setString(1, StudentName);
                preparedStatement.setInt(2, StudentID);

                int rowCount = preparedStatement.executeUpdate();
                System.out.println("Updated Rows: " + rowCount);
            }

            System.out.println("\nUpdated Table \n");
            selectMethod(optionCase);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteMethod(char optionCase) {
        System.out.println("Deleting Student mode enabled: ");

        try {
            String tableOptionCase = valuesOfTable.get(optionCase);
            System.out.println("Student DB contains: ");

            selectMethod(optionCase);

            System.out.println("\nPlease insert the ID of the Student row to DELETE: ");
            int StudentID = Integer.parseInt(scan.nextLine());

            String deleteQuery = "DELETE FROM " + tableOptionCase + " WHERE StudentID = ?";
            System.out.println(deleteQuery + "\n");
            System.out.println("Are you sure you want to delete this Student? (Yes/No)\n");
            String areYouSure = scan.nextLine();

            if (areYouSure.equals("Yes")) {
                try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                    preparedStatement.setInt(1, StudentID);

                    int rowCount = preparedStatement.executeUpdate();
                    System.out.println("Updated Rows: " + rowCount);
                }

                System.out.println("\nUpdated Table \n");
                selectMethod(optionCase);
            } else {
                System.out.println("\nValue not eliminated: ");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
