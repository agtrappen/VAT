package vat.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import vat.models.Cone;
import vat.models.Sphere;

public class SphereUI {
    GridPane layout = new GridPane();
    private double ray;

    public SphereUI(){

    }

    public Parent getView() {
        Label rayLabel = new Label("Vul een straal in");
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
        layout.add(rayLabel, 0, 0);
        layout.add(rayField, 0, 1);
        layout.add(buttons, 0, 2);
        layout.setStyle("-fx-background-image: url('https://ak.picdn.net/shutterstock/videos/3605567/thumb/1.jpg');");
        rayLabel.setStyle("-fx-text-fill: #ffff; -fx-font-weight: bold");

//      Set listeners
        saveButton.setOnAction(event -> {
            String _ray = rayField.getText();
            double ray = Double.parseDouble(_ray);
            Sphere sphere = new Sphere(ray);
            sphere.save(sphere);
            rayField.clear();
        });

        return this.layout;
    }

    public void createShape(){

    }
}
