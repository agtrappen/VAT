package vat.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import vat.database.JDBCUtil;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class ExportUI {
    private JDBCUtil db = new JDBCUtil();

    public Parent getView() {
        GridPane layout = new GridPane();

        HBox buttons = new HBox();
        buttons.setSpacing(10);

        Button saveCsvButton = new Button("Export csv");
        Button saveTxtButton = new Button("Export txt");
        Button readCsvButton = new Button("Read csv");
        Button readTxtButton = new Button("Read txt");

        buttons.getChildren().addAll(saveCsvButton, saveTxtButton, readCsvButton, readTxtButton);

        // Styling
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setStyle("-fx-background-image: url('https://ak.picdn.net/shutterstock/videos/3605567/thumb/1.jpg');");

        // Set components
        layout.add(buttons, 0, 2);

        readCsvButton.setOnAction((event) -> {
            try {
                loadFile("csv");
            } catch (FileNotFoundException | SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        readTxtButton.setOnAction((event) -> {
            try {
                loadFile("txt");
            } catch (FileNotFoundException | SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        saveCsvButton.setOnAction((event) -> {
            try {
                loadShape("csv");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        saveTxtButton.setOnAction((event) -> {
            try {
                loadShape("txt");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        return layout;
    }

    public void loadShape(String file) throws SQLException {
        db.loadShapes(file);
    }

    public void loadFile(String file) throws FileNotFoundException, SQLException {
        db.loadFile(file);
    }
}
