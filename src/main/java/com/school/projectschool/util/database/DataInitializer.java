package com.school.projectschool.util.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataInitializer  {
    public void InitializeData() {

        try (Connection connection = MySqlConnection.getConnection() ){
            deleteAll(connection);

            insertStudents(connection);
            insertInstructors(connection);
            insertClassroom(connection);
            insertCourses(connection);
            insertEnrollment(connection);
            insertGrade(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteAll(Connection connection) throws SQLException {
        // String with all tables
        String[] Tables = { "Grades", "Enrollment", "Course", "Classroom","Instructor", "Student"};
        for (String i : Tables){
            // loop for delete data
            String Clear = "DELETE FROM " + i + ";"; 
            PreparedStatement ClearStatement = connection.prepareStatement(Clear);  
            ClearStatement.execute(); 
        }
    }


    private static void insertStudents(Connection connection) throws SQLException {
        String insertStudentQuery = "INSERT INTO Student (StudentID, StudentName) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(insertStudentQuery)) {
            statement.setInt(1, 1);  // Student 01
            statement.setString(2, "Abigail Garcia");
            statement.executeUpdate();

            statement.setInt(1, 2);  // Student 02
            statement.setString(2, "Felipe Silva");
            statement.executeUpdate();

            statement.setInt(1, 3);  // Student 03
            statement.setString(2, "Esther Alves");
            statement.executeUpdate();

            statement.setInt(1, 4);  // Student 04
            statement.setString(2, "Lucas Oliveira");
            statement.executeUpdate();

            statement.setInt(1, 5);  // Student 05
            statement.setString(2, "Marina Santos");
            statement.executeUpdate();

            statement.setInt(1, 6);  // Student 06
            statement.setString(2, "Rafael Pereira");
            statement.executeUpdate();

            statement.setInt(1, 7);  // Student 07
            statement.setString(2, "Isabela Costa");
            statement.executeUpdate();

            statement.setInt(1, 8);  // Student 08
            statement.setString(2, "Olivia Johnson");
            statement.executeUpdate();

            statement.setInt(1, 9);  // Student 09
            statement.setString(2, "Noah Smith");
            statement.executeUpdate();

            statement.setInt(1, 10);  // Student 10
            statement.setString(2, "Harper Hall");
            statement.executeUpdate();

            statement.setInt(1, 11);  // Student 11
            statement.setString(2, "Bryan Satos");
            statement.executeUpdate();

            statement.setInt(1, 12);  // Student 12
            statement.setString(2, "Fatima Mcneil");
            statement.executeUpdate();

            statement.setInt(1, 13);  // Student 13
            statement.setString(2, "Dave Gil");
            statement.executeUpdate();

            statement.setInt(1, 14);  // Student 14
            statement.setString(2, "Sahib Abudabi");
            statement.executeUpdate();

            statement.setInt(1, 15);  // Student 15
            statement.setString(2, "Tony Stark");
            statement.executeUpdate();

            statement.setInt(1, 16);  // Student 16
            statement.setString(2, "Megan Fox");
            statement.executeUpdate();

            statement.setInt(1, 17);  // Student 17
            statement.setString(2, "Alexandra Navas");
            statement.executeUpdate();

            statement.setInt(1, 18);  // Student 18
            statement.setString(2, "Elias Taco");
            statement.executeUpdate();

            statement.setInt(1, 19);  // Student 19
            statement.setString(2, "Estefania Bermudes");
            statement.executeUpdate();

            statement.setInt(1, 20);  // Student 20
            statement.setString(2, "Danny Rengifo");
            statement.executeUpdate();
        }
    }

    private static void insertInstructors(Connection connection) throws SQLException {
        String insertInstructorQuery = "INSERT INTO Instructor (InstructorID, InstructorName) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(insertInstructorQuery)) {
            statement.setInt(1, 1);  // Instructor 01
            statement.setString(2, "Ethan Davis");
            statement.executeUpdate();

            statement.setInt(1, 2);  // Instructor 02
            statement.setString(2, "Amelia Heart");
            statement.executeUpdate();

            statement.setInt(1, 3);  // Instructor 03
            statement.setString(2, "John Cooper");
            statement.executeUpdate();
        }
    }

    private static void insertClassroom(Connection connection) throws SQLException {
        String insertInstructorQuery = "INSERT INTO Classroom (ClassroomID, ClassroomNumber) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(insertInstructorQuery)) {
            statement.setInt(1, 1);  // Classroom 01
            statement.setInt(2, 101);
            statement.executeUpdate();

            statement.setInt(1, 2);  // Classroom 02
            statement.setInt(2, 201);
            statement.executeUpdate();

            statement.setInt(1, 3);  // Classroom 03
            statement.setInt(2, 301);
            statement.executeUpdate();
        }
    }

    private static void insertCourses(Connection connection) throws SQLException {
        String insertCourseQuery = "INSERT INTO Course (CourseID, CourseName, InstructorID, ClassroomID) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(insertCourseQuery)) {
           
            statement.setInt(1, 1001);
            statement.setString(2, "Software Quality Assurance and Testing");
            statement.setInt(3, 1);
            statement.setInt(4, 3);
            statement.executeUpdate();

            statement.setInt(1, 1002);
            statement.setString(2, "Test Automation and Scripting");
            statement.setInt(3, 3);
            statement.setInt(4, 2);
            statement.executeUpdate();

            statement.setInt(1, 1003);
            statement.setString(2, "Introduction to Linux");
            statement.setInt(3, 2);
            statement.setInt(4, 1);
            statement.executeUpdate();
       }
    
   }

   private static void insertEnrollment(Connection connection) throws SQLException {
    String insertCourseQuery = "INSERT INTO Enrollment (StudentID, CourseID, InstructorID, EnrollmentID) VALUES (?, ?, ?, ?)";
    try (PreparedStatement statement = connection.prepareStatement(insertCourseQuery)) {
        
        statement.setInt(1, 2);
        statement.setInt(2, 1003);
        statement.setInt(3, 2); 
        statement.setInt(4, 20241); 
        statement.executeUpdate();

        statement.setInt(1, 5);
        statement.setInt(2, 1001);
        statement.setInt(3, 1); 
        statement.setInt(4, 20242); 
        statement.executeUpdate();

        statement.setInt(1, 8);
        statement.setInt(2, 1002);
        statement.setInt(3, 3); 
        statement.setInt(4, 20243); 
        statement.executeUpdate();
   }
}

private static void insertGrade(Connection connection) throws SQLException {
    String insertCourseQuery = "INSERT INTO Grades (StudentID, CourseID, GradesID, Grades) VALUES (?, ?, ?, ?)";
    try (PreparedStatement statement = connection.prepareStatement(insertCourseQuery)) {
        
        statement.setInt(1, 2);
        statement.setInt(2, 1003);
        statement.setInt(3, 1); 
        statement.setInt(4, 85); 
        statement.executeUpdate();

        statement.setInt(1, 5);
        statement.setInt(2, 1001);
        statement.setInt(3, 2); 
        statement.setInt(4, 79); 
        statement.executeUpdate();

        statement.setInt(1, 8);
        statement.setInt(2, 1002);
        statement.setInt(3, 3); 
        statement.setInt(4, 91); 
        statement.executeUpdate();
   }

}
}