package com.school.projectschool.util.CRUD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InstructorResources extends BaseResources {

    public InstructorResources() {
        super();
    }

    public void insertMethod(char optionCase) {

        System.out.println("Insert Instructor mode enabled: ");

        try {
            String tableOptionCase = valuesOfTable.get(optionCase);
            System.out.println("Instructor DB contains: ");

            selectMethod(optionCase);
            int instructorId = getNextId(optionCase);

            System.out.println("\n Please insert the name of Instructor' instructorName: ");
            String instructorName = scan.nextLine();

            String insertQuery = "INSERT INTO " + tableOptionCase + " (InstructorID, InstructorName) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setInt(1, instructorId);
                preparedStatement.setString(2, instructorName);
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
        System.out.println("Editing Instructor enabled: ");

        try {
            String tableOptionCase = valuesOfTable.get(optionCase);
            System.out.println("Instructor DB contains: ");

            selectMethod(optionCase);

            System.out.println("\n Please insert the ID of the Instructor row to edit: ");
            int instructorID = Integer.parseInt(scan.nextLine());

            System.out.println("Assign the new Name: ");
            String instructorName = scan.nextLine();

            String updateQuery = "UPDATE " + tableOptionCase + " SET InstructorName = ? WHERE InstructorID = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setString(1, instructorName);
                preparedStatement.setInt(2,  instructorID);

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
        System.out.println("Deleting Instructor mode enabled: ");

        try {
            String tableOptionCase = valuesOfTable.get(optionCase);
            System.out.println("Instructor DB contains: ");

            selectMethod(optionCase);

            System.out.println("\n Please insert the ID of the Instructor row to DELETE: ");
            int InstructorID = Integer.parseInt(scan.nextLine());

            String deleteQuery = "DELETE FROM " + tableOptionCase + " WHERE InstructorID = ?";
            System.out.println(deleteQuery + "\n");
            System.out.println("Are you sure you want to delete this Instructor? (Yes/No)\n");
            String areYouSure = scan.nextLine();

            if (areYouSure.equals("Yes")) {
                try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                    preparedStatement.setInt(1, InstructorID);

                    int rowCount = preparedStatement.executeUpdate();
                    System.out.println("Updated Rows: " + rowCount);
                }

                System.out.println("\nUpdated Table \n");
                selectMethod(optionCase);
            } else {
                System.out.println("\n value not eliminated: ");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected int getNextId(char optionCase) throws SQLException {
        String tableOptionCase = valuesOfTable.get(optionCase);
        String sql = "SELECT MAX(InstructorID) + 1 AS nextId FROM " + tableOptionCase;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            int nextId = 1;

            if (resultSet.next()) {
                nextId = resultSet.getInt("nextId");
            }

            return nextId;
        }
    }
}
