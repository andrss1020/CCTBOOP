package com.school.projectschool.util.CRUD;

import com.school.projectschool.Classrooms;

import javax.security.auth.Subject;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClassroomResources     extends BaseResources {

    public ClassroomResources() {
        super();
    }

    public void insertMethod(char optionCase) {

        System.out.println("Insert Classrooms mode enabled: ");

        try {
            String tableOptionCase = valuesOfTable.get(optionCase);
            System.out.println("Classrooms DB contains: ");

            selectMethod(optionCase);
            System.out.println("\n Please insert the new Classrooms' idClass: ");
            int ClassroomsID = Integer.parseInt(scan.nextLine());
            System.out.println("Assign the ClassroomsID now: ");
            String ClassroomsCode = (scan.nextLine());

            String insertQuery = "INSERT INTO " + tableOptionCase + " (ClasroomsID, ClassroomsCode) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setInt(1, ClassroomsID);
                preparedStatement.setString(2, ClassroomsCode);
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
        System.out.println("Editing Classrooms enabled: ");

        try {
            String tableOptionCase = valuesOfTable.get(optionCase);
            System.out.println("Classrooms DB contains: ");

            selectMethod(optionCase);

            System.out.println("\n Please insert the ID of the classrooms row to edit: ");
            String Subject = scan.nextLine();

            System.out.println("Enter the new Classrooms ID: ");
            System.out.println("Assign the new Name: ");
            int ClassroomsId = Integer.parseInt(scan.nextLine());
            String ClassroomsCode = "CCTB-Classrooms" + ClassroomsID;

            String updateQuery = "UPDATE " + tableOptionCase + " SET ClassroomsID = ?, Subject = ? WHERE ClassroomsCode = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setInt(1, ClassroomsId);
                preparedStatement.setString(2, Subject);
                preparedStatement.setString(3, ClassroomsCode);

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
        System.out.println("Deleting Classrooms mode enabled: ");

        try {
            String tableOptionCase = valuesOfTable.get(optionCase);
            System.out.println("Classrooms DB contains: ");

            selectMethod(optionCase);

            System.out.println("\n Please insert the ID of the Classrooms row to DELETE: ");
            int ClassroomsId = Integer.parseInt(scan.nextLine());

            String deleteQuery = "DELETE FROM " + tableOptionCase + " WHERE ClassroomsId = ?";
            System.out.println(deleteQuery + "\n");
            System.out.println("Are you sure you want to delete this Classrooms? (Yes/No)\n");
            String areYouSure = scan.nextLine();

            if (areYouSure.equals("Yes")) {
                try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                    preparedStatement.setInt(1, ClassroomsId);

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
