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
            System.out.println("Class DB contains: ");

            selectMethod(optionCase);
            System.out.println("\n Please insert the new Grades' idClass: ");
            int studentId = Integer.parseInt(scan.nextLine());
            System.out.println("Assign the Course ID now: ");
            int courseId = Integer.parseInt(scan.nextLine());

            String insertQuery = "INSERT INTO " + tableOptionCase + " (StudentId, CourseId) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setInt(1, studentId);
                preparedStatement.setInt(2, courseId);
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
            int gradeId = Integer.parseInt(scan.nextLine());

            System.out.println("Enter the new Student ID: ");
            int studentId = Integer.parseInt(scan.nextLine());
            System.out.println("Assign the new Course ID: ");
            int courseId = Integer.parseInt(scan.nextLine());

            String updateQuery = "UPDATE " + tableOptionCase + " SET StudentId = ?, CourseId = ? WHERE GradeId = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setInt(1, studentId);
                preparedStatement.setInt(2, courseId);
                preparedStatement.setInt(3, gradeId);

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

            String deleteQuery = "DELETE FROM " + tableOptionCase + " WHERE GradeId = ?";
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
}