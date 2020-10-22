package vat.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class PyramidUI {

    public Parent getView() {
        GridPane layout = new GridPane();

        Label rayLabel = new Label("Straal");
        TextField rayField = new TextField();

        HBox buttons = new HBox();
        buttons.setSpacing(10);

        Button saveButton = new Button("OK");
        Button cancelButton = new Button("Annuleer");

        buttons.getChildren().addAll(saveButton, cancelButton);

        // Styling
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        // Set components
        layout.add(rayLabel, 0, 0);
        layout.add(rayField, 0, 1);
        layout.add(buttons, 0, 2);
        layout.setStyle("-fx-background-image: url('https://ak.picdn.net/shutterstock/videos/3605567/thumb/1.jpg');");
        rayLabel.setStyle("-fx-text-fill: #ffff; -fx-font-weight: bold");

        return layout;
    }
}
