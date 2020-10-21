package vat.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class CylinderUI {


    public Parent getView() {
        GridPane layout = new GridPane();

        // Ray field
        Label rayLabel = new Label("Straal");
        TextField rayField = new TextField();
        Button saveButton = new Button("OK");

        // Height field
        Label heightLabel = new Label("Hoogte");
        TextField heightField = new TextField();

        // Cancel button
        Button cancelButton = new Button("Annuleer");

        // Styling
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        // Set components
        layout.add(rayLabel, 0, 0);
        layout.add(rayField, 0, 1);
        layout.add(saveButton, 0, 2);
        layout.add(heightLabel, 5, 0);
        layout.add(heightField, 5, 1);
        layout.add(cancelButton, 5, 2);
        layout.setStyle("-fx-background-image: url('https://ak.picdn.net/shutterstock/videos/3605567/thumb/1.jpg');");
        rayLabel.setStyle("-fx-text-fill: #ffff; -fx-font-weight: bold");
        heightLabel.setStyle("-fx-text-fill: #ffff; -fx-font-weight: bold");

        return layout;
    }
}
