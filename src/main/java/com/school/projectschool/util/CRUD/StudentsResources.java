package com.school.projectschool.util.CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//Class Students to be called by the Student Management Menu
public class StudentsResources {

    public StudentsResources() {
        super();
    }

    public static void insertMethod(Connection connection) throws SQLException {

        String insertStudentQuery = "INSERT INTO Student (StudentID, StudentName) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(insertStudentQuery)) {

            // Obtém o próximo valor do sequenciador para StudentID
            int nextStudentID = nextStudentID(connection);

            // Solicita ao usuário as informações do novo estudante
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please insert the student name:");
            String nome = scanner.nextLine();
            scanner.close();

            //Executa o query para add novo estudante na tabela
            statement.setInt(1, nextStudentID);
            statement.setString(2, nome);
            int afectedLines = statement.executeUpdate();

            // Verifica se a inserção foi bem-sucedida
            if (afectedLines > 0) {
                System.out.println("Student added!");
            } else {
                System.out.println("Error to add student");
            }

        }
    }


    public static void StudentDelete(Connection connection) throws SQLException {

        String deleteStudentQuery = "DELETE FROM Student WHERE StudentID = ?";

        try (PreparedStatement statement = connection.prepareStatement(deleteStudentQuery)) {

            // Solicita ao usuário as informações do estudante
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please insert the Student ID to be deleted:");
            Integer deleteStudentID = scanner.nextInt();
            scanner.close();

            //Executa o query para deletar estudante na tabela
            statement.setInt(1, deleteStudentID);
            int afectedLines = statement.executeUpdate();

            // Verifica se a inserção foi bem-sucedida
            if (afectedLines > 0) {
                System.out.println("Student deleted!");
            } else {
                System.out.println("Student ID not found.");
            }

        }
    }


    public static void StudentEdit(Connection connection) throws SQLException {

        String editStudentQuery = "UPDATE Student SET StudentName = ? WHERE StudentID = ?";

        try (PreparedStatement statement = connection.prepareStatement(editStudentQuery)) {

            // Solicita ao usuário as informações do estudante
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please insert the Student ID to be edited:");
            Integer editStudentID = scanner.nextInt();

            System.out.println("Please insert the new name for the student:");
            scanner.nextLine();
            String newStudentName = scanner.nextLine();

            //Executa o query para deletar estudante na tabela
            statement.setString(1, newStudentName);
            statement.setInt(2, editStudentID);

            int afectedLines = statement.executeUpdate();

            // Verifica se a inserção foi bem-sucedida
            if (afectedLines > 0) {
                System.out.println("Student deleted!");
            } else {
                System.out.println("Student ID not found.");
            }

        }
    }

    private static int nextStudentID(Connection connection) throws SQLException {
        // Obtém o próximo valor do sequenciador para StudentID
        String sql = "SELECT MAX(StudentID) + 1 AS nextStudentID FROM Student";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        int nextStudentID = 1;

        if (resultSet.next()) {
            nextStudentID = resultSet.getInt("nextStudentID");
        }

        resultSet.close();
        preparedStatement.close();

        return nextStudentID;
    }

}

