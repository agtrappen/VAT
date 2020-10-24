package vat.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import vat.database.JDBCUtil;

import java.sql.SQLException;

public class ExportUI {
    private JDBCUtil db = new JDBCUtil();

    public Parent getView() {
        GridPane layout = new GridPane();

        HBox buttons = new HBox();
        buttons.setSpacing(10);

        Button saveButton = new Button("Export csv");

        buttons.getChildren().add(saveButton);

        // Styling
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setStyle("-fx-background-image: url('https://ak.picdn.net/shutterstock/videos/3605567/thumb/1.jpg');");

        // Set components
        layout.add(buttons, 0, 2);

        saveButton.setOnAction((event) -> {
            try {
                loadShape();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        return layout;
    }

    public void loadShape() throws SQLException {
        db.loadShapes();
    }
}
