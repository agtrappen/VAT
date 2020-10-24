package vat.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import vat.models.Sphere;

public class SphereUI {
    GridPane layout = new GridPane();
    private double ray;
    private String name = "Sphere";

    public SphereUI(){

    }

    public Parent getView() {
        Label rayLabel = new Label("Vul een straal in");
        TextField rayField = new TextField();

        HBox buttons = new HBox();
        buttons.setSpacing(10);

        Button closeButton = new Button("Cancel");
        Button saveButton = new Button("OK");

        buttons.getChildren().addAll(saveButton, closeButton);

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

//      Set listeners
        closeButton.setOnAction(event ->{
            Stage stage = (Stage) closeButton.getScene().getWindow();
            stage.close();
        });

        saveButton.setOnAction(event -> {
            String _ray = rayField.getText();
            double ray = Double.parseDouble(_ray);
            Sphere sphere = new Sphere(ray);
            double contentSphere = sphere.calculate(sphere);
            Shape newShape = new Shape(this.name, contentSphere);
            newShape.save(newShape);
            rayField.clear();
        });

        return this.layout;
    }
}
