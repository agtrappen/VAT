package vat.database;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;


public class JDBCUtil {
    // Replace below database url, username and password with your actual database credentials
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/vat?useSSL=false";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "";
    private static final String INSERT_QUERY = "UPDATE shapes SET content=? WHERE shape_name=?";
    private static final String SELECT_QUERY = "SELECT * FROM shapes";
    private static final String DELETE_QUERY = "DELETE FROM Users WHERE shape_name=?";

    public void insertShape(Double content, String shapeName) throws SQLException {

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY))
        {
            preparedStatement.setDouble(1, content);
            preparedStatement.setString(2, shapeName);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public void loadShapes() throws SQLException {

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(SELECT_QUERY))
        {
            String csvFilePath = "shapes.csv";
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(csvFilePath));
            Desktop desktop = Desktop.getDesktop();

            // write header line containing column names
            fileWriter.write("id,content,shape_name");

            while (result.next()) {
                Integer id = result.getInt("id");
                Double content = result.getDouble("content");
                String shapeName = result.getString("shape_name");

                String line = String.format("\"%s\",%s, %s",
                        id, content, shapeName);

                fileWriter.newLine();
                fileWriter.write(line);
            }

            statement.close();
            fileWriter.close();

            desktop.open(new File(csvFilePath));
        } catch (SQLException | IOException e) {
            printSQLException((SQLException) e);
        }
    }

    public void deleteShape(String shapeName) throws SQLException {

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY))
        {
            preparedStatement.setString(1, shapeName);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
