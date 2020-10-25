package vat.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import java.awt.*;
import java.io.*;
import java.nio.CharBuffer;
import java.sql.*;
import java.util.Scanner;


public class JDBCUtil {
    // Replace below database url, username and password with your actual database credentials
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/vat?useSSL=false";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "";
    private static final String INSERT_QUERY = "INSERT INTO shapes (content, shape_name) VALUES (?, ?)";
    private static final String SELECT_QUERY_ALL = "SELECT * FROM shapes";
    private static final String DELETE_QUERY = "DELETE FROM shapes WHERE id=?";
    private static final String TOTAL_CONTENT_QUERY = "SELECT sum(content) FROM shapes";
    private Shape shape;

    /**
     *
     * @param content
     * @param shapeName
     * @throws SQLException
     */
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

    public String getTotalContent() throws SQLException {
        String resultSum = "";
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(TOTAL_CONTENT_QUERY))
        {
            result.next();
            Double content = result.getDouble(1);
            resultSum = String.valueOf(content);
            statement.close();
        } catch (SQLException e) {
            printSQLException(e);
        }
        return resultSum;
    }



    public ObservableList<String> getShape() throws SQLException {

        ObservableList<String> list = FXCollections.observableArrayList();
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(SELECT_QUERY_ALL))
        {
            while (result.next()) {
                Integer id = result.getInt("id");
                Double content = result.getDouble("content");
                String shapeName = result.getString("shape_name");
                String _id = String.valueOf(id);
                String _content = String.valueOf(content);
                list.add(_id + " " + shapeName + " " + _content);
            }
            statement.close();
        } catch (SQLException e) {
            printSQLException(e);
        }
        return list;
    }

    /**
     *
     * @throws SQLException
     */
    public void loadShapes(String file) throws SQLException {

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(SELECT_QUERY_ALL))
        {
            String filePath = "shapes." + file;
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(filePath));
            Desktop desktop = Desktop.getDesktop();

            // write header line containing column names
            fileWriter.write("id,content,shape_name");

            while (result.next()) {
                Integer id = result.getInt("id");
                Double content = result.getDouble("content");
                String shapeName = result.getString("shape_name");

                String line = String.format("\"%s\",%s,%s",
                        id, content, shapeName);

                fileWriter.newLine();
                fileWriter.write(line);
            }

            statement.close();
            fileWriter.close();

            desktop.open(new File(filePath));
        } catch (SQLException | IOException e) {
            printSQLException((SQLException) e);
        }
    }

    public void loadFile(String file) throws FileNotFoundException, SQLException {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY))
        {
            File myObj = new File("shapes." + file);
            Scanner myReader = new Scanner(myObj);

            myReader.nextLine();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String test = data.split(",")[1];
                System.out.println("test" + test);
                double content = Double.parseDouble(test);
                String shapeName = data.split(",")[2];
                preparedStatement.setDouble(1, content);
                preparedStatement.setString(2, shapeName);
                preparedStatement.executeUpdate();
            }
            myReader.close();
        }catch (FileNotFoundException | SQLException e){
            System.out.println(e);
        }
    }

    /**
     *
     * @param id
     * @throws SQLException
     */
    public void deleteShape(Integer id) throws SQLException {

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY))
        {
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    /**
     *
     * @param ex
     */
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
