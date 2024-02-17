package com.school.projectschool.util.CRUD;

import com.school.projectschool.util.database.MySqlConnection;
import java.sql.*;
public class CoursesResources extends BaseResources {
    public CoursesResources() {
        super();
    }

    public void insertMethod(char optionCase) {

        System.out.println("Insert Class mode enabled: ");

        try {
            // Make the first selection to show what the user is seeing.
            String tableOptionCase = valuesOfTable.get(optionCase);
            System.out.println("Class DB contains: ");
            selectMethod(optionCase);
            int courseID = getNextId(optionCase);
            System.out.println("\n Please insert the new Course' name: ");
            String courseName = scan.nextLine();
            System.out.println("Assign the Instructor ID now: ");
            selectMethod('I');
            int instructorID = Integer.parseInt(scan.nextLine());
            System.out.println("Assign the Classroom ID now: ");
            selectMethod('R');
            int classroomID = Integer.parseInt(scan.nextLine());

            String insertQuery = "INSERT INTO " + tableOptionCase + " (CourseID, CourseName, InstructorID, ClassroomID) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setInt(1, courseID);
                preparedStatement.setString(2, courseName);
                preparedStatement.setInt(3, instructorID);
                preparedStatement.setInt(4, classroomID);
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
        System.out.println("Editing Courses mode enabled: ");

        try {
            String tableOptionCase = valuesOfTable.get(optionCase);
            System.out.println("Courses DB contains: ");

            selectMethod(optionCase);

            System.out.println("\n Please insert the ID of the course row to edit: ");
            int courseId = Integer.parseInt(scan.nextLine());

            System.out.println("Assign the new Course Name: ");
            String courseName = scan.nextLine();

            System.out.println("Assign the new Instructor ID: ");
            selectMethod('I');
            int instructorID = Integer.parseInt(scan.nextLine());

            System.out.println("Assign the new Classroom ID: ");
            selectMethod('R');
            int classroomID = Integer.parseInt(scan.nextLine());

            String updateQuery = "UPDATE " + tableOptionCase + " SET CourseName = ?, InstructorID  = ?, ClassroomID = ? WHERE CourseID = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setString(1, courseName);
                preparedStatement.setInt(2, instructorID);
                preparedStatement.setInt(3, classroomID);
                preparedStatement.setInt(4, courseId);

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
        System.out.println("Deleting Course mode enabled: ");
        try {
            String tableOptionCase = valuesOfTable.get(optionCase);
            System.out.println("Course DB contains: ");

            selectMethod(optionCase);

            System.out.println("\nPlease insert the ID of the Course row to DELETE: ");
            int courseID = Integer.parseInt(scan.nextLine());

            String deleteQuery = "DELETE FROM " + tableOptionCase + " WHERE CourseID = ?";
            System.out.println(deleteQuery + "\n");
            System.out.println("Are you sure you want to delete this Course? (Yes/No)\n");
            String areYouSure = scan.nextLine();

            if (areYouSure.equals("Yes")) {
                try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                    preparedStatement.setInt(1, courseID);

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

    protected int getNextId(char optionCase) throws SQLException {
        String tableOptionCase = valuesOfTable.get(optionCase);
        String sql = "SELECT MAX(CourseID) + 1 AS nextId FROM " + tableOptionCase;
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
