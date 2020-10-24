package vat.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import vat.models.Block;
import vat.models.Cone;


public class ConeUI {
    GridPane layout = new GridPane();
    private double ray;
    private double height;

    public ConeUI(){

    }

    public Parent getView() {
        Label heightLabel = new Label("Vul een hoogte in");
        Label rayLabel = new Label("Vul een straal in");
        TextField heightField = new TextField();
        TextField rayField = new TextField();

        HBox buttons = new HBox();
        buttons.setSpacing(10);

        Button saveButton = new Button("OK");

        buttons.getChildren().addAll(saveButton);

        // Styling
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        // Set components
        layout.add(heightLabel, 0, 0);
        layout.add(heightField, 0, 1);
        layout.add(rayLabel, 0, 2);
        layout.add(rayField, 0, 3);
        layout.add(buttons, 0, 4);
        layout.setStyle("-fx-background-image: url('https://ak.picdn.net/shutterstock/videos/3605567/thumb/1.jpg');");
        rayLabel.setStyle("-fx-text-fill: #ffff; -fx-font-weight: bold");
        heightLabel.setStyle("-fx-text-fill: #ffff; -fx-font-weight: bold");

//      Set listeners
        saveButton.setOnAction(event -> {
            String _height = heightField.getText();
            String _ray = rayField.getText();
            double height = Double.parseDouble(_height);
            double ray = Double.parseDouble(_ray);
            Cone cone = new Cone(height, ray);
            cone.save(cone);
            heightField.clear();
            rayField.clear();
        });

        return this.layout;
    }

    public void createShape(){

    }
}
