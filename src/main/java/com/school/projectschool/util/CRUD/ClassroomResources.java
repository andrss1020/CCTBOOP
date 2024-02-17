package com.school.projectschool.util.CRUD;

import com.school.projectschool.Classrooms;

import javax.security.auth.Subject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            int classroomID = getNextId(optionCase);
            System.out.println("Assign the Classrooms Number now: ");
            int classroomNumber = Integer.parseInt(scan.nextLine());

            String insertQuery = "INSERT INTO " + tableOptionCase + " (ClassroomID, ClassroomNumber) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setInt(1, classroomID);
                preparedStatement.setInt(2, classroomNumber);
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
            int classroomId = Integer.parseInt(scan.nextLine());
            System.out.println("Assign the new Classroom Number: ");
            int classroomNumber = Integer.parseInt(scan.nextLine());;

            String updateQuery = "UPDATE " + tableOptionCase + " SET ClassroomNumber = ? WHERE ClassroomID = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setInt(1, classroomNumber);
                preparedStatement.setInt(2, classroomId);

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
            int classroomId = Integer.parseInt(scan.nextLine());

            String deleteQuery = "DELETE FROM " + tableOptionCase + " WHERE ClassroomID = ?";
            System.out.println("Are you sure you want to delete this Classrooms? (Yes/No)\n");
            String areYouSure = scan.nextLine();

            if (areYouSure.equals("Yes")) {
                try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                    preparedStatement.setInt(1, classroomId);

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
        String sql = "SELECT MAX(ClassroomID) + 1 AS nextId FROM " + tableOptionCase;
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
