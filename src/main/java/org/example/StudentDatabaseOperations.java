package org.example;

import java.sql.*;

public class StudentDatabaseOperations {
    public static void main(String[] args) {

        String baseUrl = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "Omerabub2005@";

        try {

            Connection serverConnection = DriverManager.getConnection(baseUrl, username, password);
            Statement serverStatement = serverConnection.createStatement();

            serverStatement.executeUpdate("CREATE DATABASE IF NOT EXISTS StudentsDB");
            System.out.println("Database 'StudentsDB' is ready.");

            serverStatement.close();
            serverConnection.close();


            String dbUrl = "jdbc:mysql://localhost:3306/StudentsDB";
            Connection dbConnection = DriverManager.getConnection(dbUrl, username, password);
            Statement dbStatement = dbConnection.createStatement();


            String createTableSQL =
                    "CREATE TABLE IF NOT EXISTS students ("
                            + "id INT PRIMARY KEY, "
                            + "firstname VARCHAR(255), "
                            + "lastname VARCHAR(255), "
                            + "grade INT)";

            dbStatement.execute(createTableSQL);

            System.out.println("Table 'students' created successfully.");


            // Remove old records so the program can run again

            dbStatement.executeUpdate("DELETE FROM students");


            // INSERT DATA

            String insertSQL =
                    "INSERT INTO students (id, firstname, lastname, grade) VALUES "
                            + "(1, 'John', 'Doe', 90),"
                            + "(2, 'Abebe', 'Kebede', 85),"
                            + "(3, 'Marta', 'Ali', 95),"
                            + "(4, 'Sara', 'Bekele', 88),"
                            + "(5, 'Daniel', 'Tesfaye', 75),"
                            + "(6, 'Liya', 'Solomon', 92),"
                            + "(7, 'Samuel', 'Getachew', 80),"
                            + "(8, 'Hana', 'Mulu', 87),"
                            + "(9, 'Elias', 'Yosef', 78),"
                            + "(10, 'Rahel', 'Alemu', 91),"
                            + "(11, 'Miki', 'Haile', 84)";


            dbStatement.executeUpdate(insertSQL);

            System.out.println("Students inserted successfully.");


            // RETRIEVE DATA

            String selectSQL = "SELECT * FROM students LIMIT 5";

            ResultSet result = dbStatement.executeQuery(selectSQL);

            System.out.println("\nStudent Records:");

            while (result.next()) {

                int id = result.getInt("id");
                String firstname = result.getString("firstname");
                String lastname = result.getString("lastname");
                int grade = result.getInt("grade");

                System.out.println(
                        id + " | "
                                + firstname + " "
                                + lastname
                                + " | Grade: "
                                + grade
                );
            }


            // UPDATE DATA

            String updateSQL =
                    "UPDATE students SET firstname='UpdatedJohn' WHERE id=1";

            dbStatement.executeUpdate(updateSQL);

            System.out.println("\nStudent updated successfully.");


            // DELETE DATA

            String deleteSQL =
                    "DELETE FROM students WHERE id=2";

            dbStatement.executeUpdate(deleteSQL);

            System.out.println("Student deleted successfully.");


            // CALCULATE AVERAGE GRADE

            String averageSQL =
                    "SELECT AVG(grade) AS average_grade FROM students";

            ResultSet averageResult =
                    dbStatement.executeQuery(averageSQL);


            if (averageResult.next()) {

                double average =
                        averageResult.getDouble("average_grade");

                System.out.println("Average Grade: " + average);
            }


            // CLOSE CONNECTION

            result.close();
            averageResult.close();
            dbStatement.close();
            dbConnection.close();


            System.out.println("\nConnection closed successfully.");


        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}