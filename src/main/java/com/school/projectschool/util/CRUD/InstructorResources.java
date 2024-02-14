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
            String tableOptionCase = valuesOfMap.get(optionCase);
            System.out.println("Instructor DB contains: ");

            selectMethod(optionCase);
            System.out.println("\n Please insert the new Instructor' idClass: ");
            int InstructorId = Integer.parseInt(scan.nextLine());
            System.out.println("Assign the InstructorId now: ");
            String InstructorCode = (scan.nextLine());

            String insertQuery = "INSERT INTO " + tableOptionCase + " (InstructorId, InstructorCode) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setInt(1, InstructorId);
                preparedStatement.setString(2, InstructorCode);
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
            String tableOptionCase = valuesOfMap.get(optionCase);
            System.out.println("Instructor DB contains: ");

            selectMethod(optionCase);

            System.out.println("\n Please insert the ID of the grade row to edit: ");
            String Name = scan.nextLine();

            System.out.println("Enter the new Instructor ID: ");
            System.out.println("Assign the new Name: ");
            int InstructorId = Integer.parseInt(scan.nextLine());
            String InstructorCode = "CCTB-Instructor" + InstructorId;

            String updateQuery = "UPDATE " + tableOptionCase + " SET InstructorId = ?, Name = ? WHERE InstructorCode = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setInt(1, InstructorId);
                preparedStatement.setString(2, Name );
                preparedStatement.setString(3, InstructorCode);

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
        System.out.println("Deleting Grades mode enabled: ");

        try {
            String tableOptionCase = valuesOfMap.get(optionCase);
            System.out.println("Instructor DB contains: ");

            selectMethod(optionCase);

            System.out.println("\n Please insert the ID of the Instructor row to DELETE: ");
            int InstructorId = Integer.parseInt(scan.nextLine());

            String deleteQuery = "DELETE FROM " + tableOptionCase + " WHERE InstructorId = ?";
            System.out.println(deleteQuery + "\n");
            System.out.println("Are you sure you want to delete this Instructor? (Yes/No)\n");
            String areYouSure = scan.nextLine();

            if (areYouSure.equals("Yes")) {
                try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                    preparedStatement.setInt(1, InstructorId);

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
