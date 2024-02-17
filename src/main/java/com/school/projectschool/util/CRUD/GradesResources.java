package com.school.projectschool.util.CRUD;


import java.sql.*;
public class GradesResources extends BaseResources{
    public GradesResources() {
        super();
    }

    public void insertMethod(char optionCase) {

        System.out.println("Insert Grades mode enabled: ");

        try {
            // Make the first selection to show what the user is seeing.
            String tableOptionCase = valuesOfTable.get(optionCase);
            System.out.println("Grades DB contains: ");

            selectMethod(optionCase);
            int gradesId = getNextId(optionCase);
            System.out.println("\n Please insert the studentID: ");
            selectMethod('S');
            int studentId = Integer.parseInt(scan.nextLine());
            selectMethod('C');
            System.out.println("Assign the Course ID now: ");
            int courseId = Integer.parseInt(scan.nextLine());
            System.out.println("Assign the Score grade now: ");
            double scoreGrade = Double.parseDouble(scan.nextLine());

            String insertQuery = "INSERT INTO " + tableOptionCase + " (StudentID, CourseID, GradesID, Grades) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setInt(1, studentId);
                preparedStatement.setInt(2, courseId);
                preparedStatement.setInt(3, gradesId);
                preparedStatement.setDouble(4, scoreGrade);
                int rowCount = preparedStatement.executeUpdate();
                System.out.println("Updated Rows: " + rowCount);
            }

            System.out.println("\nUpdated Table \n");
            selectMethod(optionCase);
        } catch (SQLException e) {
            System.err.println("Error inserting data: " + e.getMessage());
        }
    }

    public void updateMethod(char optionCase) {
        System.out.println("Editing Grades mode enabled: ");

        try {
            String tableOptionCase = valuesOfTable.get(optionCase);
            System.out.println("Grades DB contains: ");

            selectMethod(optionCase);

            System.out.println("\n Please insert the ID of the Student row to edit: ");
            int studentID = Integer.parseInt(scan.nextLine());

            System.out.println("Assign the new Score Grade: ");
            double scoreGrade = Double.parseDouble(scan.nextLine());

            String updateQuery = "UPDATE " + tableOptionCase + " SET Grades = ? WHERE StudentID = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setDouble(1, scoreGrade);
                preparedStatement.setInt(2, studentID);

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
            String tableOptionCase = valuesOfTable.get(optionCase);
            System.out.println("Grades DB contains: ");

            selectMethod(optionCase);

            System.out.println("\n Please insert the ID of the grade row to DELETE: ");
            int gradeId = Integer.parseInt(scan.nextLine());

            String deleteQuery = "DELETE FROM " + tableOptionCase + " WHERE GradesID = ?";
            System.out.println(deleteQuery + "\n");
            System.out.println("Are you sure you want to delete this grade? (Yes/No)\n");
            String areYouSure = scan.nextLine();

            if (areYouSure.equals("Yes")) {
                try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                    preparedStatement.setInt(1, gradeId);

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
        String sql = "SELECT MAX(GradesID) + 1 AS nextId FROM " + tableOptionCase;
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