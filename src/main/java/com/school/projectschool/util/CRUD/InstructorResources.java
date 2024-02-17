package com.school.projectschool.util.CRUD;

import java.sql.PreparedStatement;
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
            System.out.println("\n Please insert the new Instructor' idClass: ");
            int InstructorID = Integer.parseInt(scan.nextLine());
            System.out.println("Assign the InstructorID now: ");

            String insertQuery = "INSERT INTO " + tableOptionCase + " (InstructorID, InstructorName) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setInt(1, InstructorID);
                preparedStatement.setString(2, InstructorName);
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
            String InstructorName = scan.nextLine();

            System.out.println("Enter the new Instructor ID: ");
            System.out.println("Assign the new Name: ");
            int InstructorID = Integer.parseInt(scan.nextLine());
            String InstructorName = "CCTB-Instructor" + InstructorID;

            String updateQuery = "UPDATE " + tableOptionCase + " SET InstructorID = ?, Name = ? WHERE InstructorCode = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setInt(1, InstructorID);
                preparedStatement.setString(2, InstructorName );

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
}
