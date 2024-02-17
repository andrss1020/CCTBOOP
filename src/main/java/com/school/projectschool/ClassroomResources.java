package com.school.projectschool;

import com.school.projectschool.util.CRUD.BaseResources;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClassroomResources extends BaseResources {
    public ClassroomResources() {
        super();
    }

    public void insertMethod(char optionCase) {

        System.out.println("Insert Classroom mode enabled: ");

        try {
            String tableOptionCase = valuesOfTable.get(optionCase);
            System.out.println("Class DB contains: ");

            selectMethod(optionCase);
            System.out.println("\n Please insert the new Classroom' idClass: ");
            int ClassroomID = Integer.parseInt(scan.nextLine());
            System.out.println("Assign the Course ID now: ");
            int ClassroomID = Integer.parseInt(scan.nextLine());

            String insertQuery = "INSERT INTO " + tableOptionCase + " (ClassroomID, ClassroomNumber) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setInt(1, ClassroomID);
                preparedStatement.setInt(2, ClassroomNumber);
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
        System.out.println("Editing Grades mode enabled: ");

        try {
            String tableOptionCase = valuesOfTable.get(optionCase);
            System.out.println("Grades DB contains: ");

            selectMethod(optionCase);

            System.out.println("\n Please insert the ID of the grade row to edit: ");
            int ClassroomID = Integer.parseInt(scan.nextLine());

            System.out.println("Enter the new Classroom ID: ");
            int ClassroomID = Integer.parseInt(scan.nextLine());
            System.out.println("Assign the new Classroom Number ID: ");
            int ClassroomNumber = Integer.parseInt(scan.nextLine());

            String updateQuery = "UPDATE " + tableOptionCase + " SET ClassroomID = ?, ClassroomNumber = ? ";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setInt(1, ClassroomID);
                preparedStatement.setInt(2, ClassroomNumber);

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
        System.out.println("Deleting Classroom mode enabled: ");

        try {
            String tableOptionCase = valuesOfTable.get(optionCase);
            System.out.println("Classroom DB contains: ");

            selectMethod(optionCase);

            System.out.println("\n Please insert the ID of the Classroom row to DELETE: ");
            int ClassroomID = Integer.parseInt(scan.nextLine());

            String deleteQuery = "DELETE FROM " + tableOptionCase + " WHERE ClassroomID = ?";
            System.out.println(deleteQuery + "\n");
            System.out.println("Are you sure you want to delete this Classroom? (Yes/No)\n");
            String areYouSure = scan.nextLine();

            if (areYouSure.equals("Yes")) {
                try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                    preparedStatement.setInt(1, ClassroomID);

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
