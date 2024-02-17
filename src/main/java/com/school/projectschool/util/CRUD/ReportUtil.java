package com.school.projectschool.util.CRUD;

import com.school.projectschool.util.database.MySqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportUtil {
    public static void generateReport() {
        try (Connection connection = MySqlConnection.getConnection()) {
            // Assuming your report query involves JOINs with parent tables and an extra table called Report
            String reportQuery = "SELECT Student.StudentID, Student.StudentName, " +
                    "Course.CourseName, Instructor.InstructorName, Grades.Grades " +
                    "FROM Student " +
                    "JOIN Grades ON Student.StudentID = Grades.StudentID " +
                    "JOIN Course ON Grades.CourseID = Course.CourseID " +
                    "JOIN Instructor ON Course.InstructorID = Instructor.InstructorID";

            try (PreparedStatement preparedStatement = connection.prepareStatement(reportQuery);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                // Print the report header
                System.out.println("Report:");
                System.out.printf("%-10s %-20s %-20s %-20s %-10s%n",
                        "StudentID", "StudentName", "CourseName", "InstructorName", "Grades");

                // Print each row of the report
                while (resultSet.next()) {
                    int studentID = resultSet.getInt("StudentID");
                    String studentName = resultSet.getString("StudentName");
                    String courseName = resultSet.getString("CourseName");
                    String instructorName = resultSet.getString("InstructorName");
                    int grades = resultSet.getInt("Grades");

                    System.out.printf("%-10d %-20s %-20s %-20s %-10d%n",
                            studentID, studentName, courseName, instructorName, grades);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
