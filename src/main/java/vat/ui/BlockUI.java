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
import vat.models.Block;
import vat.models.Shape;


public class BlockUI {
    GridPane layout = new GridPane();

    public BlockUI() {

    }

    public Parent getView() {
        Label lengthLabel = new Label("Vul een lengte in");
        Label widthLabel = new Label("Vul een breedte in");
        Label heightLabel = new Label("Vul een hoogte in");
        TextField lengthField = new TextField();
        TextField widthField = new TextField();
        TextField heightField = new TextField();

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
        layout.add(heightLabel, 0, 0);
        layout.add(heightField, 0, 1);
        layout.add(lengthLabel, 0, 2);
        layout.add(lengthField, 0, 3);
        layout.add(widthLabel, 0, 4);
        layout.add(widthField, 0, 5);
        layout.add(buttons, 0, 6);
        layout.setStyle("-fx-background-image: url('https://ak.picdn.net/shutterstock/videos/3605567/thumb/1.jpg');");
        heightLabel.setStyle("-fx-text-fill: #ffff; -fx-font-weight: bold");
        lengthLabel.setStyle("-fx-text-fill: #ffff; -fx-font-weight: bold");
        widthLabel.setStyle("-fx-text-fill: #ffff; -fx-font-weight: bold");

//      Set listeners
        closeButton.setOnAction(event ->{
            Stage stage = (Stage) closeButton.getScene().getWindow();
            stage.close();
        });

        saveButton.setOnAction(event -> {
            String _length = lengthField.getText();
            String _height = heightField.getText();
            String _width = widthField.getText();
            double length = Double.parseDouble(_length);
            double height = Double.parseDouble(_height);
            double width = Double.parseDouble(_width);
            Block block = new Block(length, height, width);
            block.save();

            lengthField.clear();
            heightField.clear();
            widthField.clear();
        });
        return this.layout;
    }
}
