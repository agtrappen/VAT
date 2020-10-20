package vat.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class MainUI {
    public Parent getView() {
        GridPane content = new GridPane();
        SphereUI sphereView = new SphereUI();

        // Shape option
        Label optionLabel = new Label("Vorm");
        ObservableList<String> options = FXCollections.observableArrayList ("bol", "blok", "cilinder");
        ComboBox shapeOptions = new ComboBox(options);

        // Content shape
        Label contentLabel = new Label("Inhoud");
        TextField contentField = new TextField();

        // Total content shape
        Label totalContentLabel = new Label("Totale inhoud");
        TextField totalContentField = new TextField();

        // Left action buttons
        Button saveButton = new Button("Opslaan");
        Button loadButton = new Button("Laad");

        // Shape list
        ListView<String> shapeList = new ListView<String>();
        ObservableList<String> items =FXCollections.observableArrayList (
                "Bol", "Blok", "Cilinder");
        shapeList.setItems(items);
        shapeList.setMaxHeight(200);

        // Total content button
        Button totalButton = new Button("Totale inhoud");

        // Delete shape button
        Button delteButton = new Button("Verwijder Vorm");

        // Styling
        content.setAlignment(Pos.CENTER);
        content.setVgap(10);
        content.setHgap(10);
        content.setPadding(new Insets(10, 10, 10, 10));

        // Set components
        content.add(optionLabel, 0, 0);
        content.add(shapeOptions, 0, 1);
        content.add(contentLabel, 0, 2);
        content.add(contentField, 0, 3);
        content.add(totalContentLabel, 0, 4);
        content.add(totalContentField, 0, 5);
        content.add(saveButton, 0, 7);
        content.add(loadButton, 0, 8);
        content.add(shapeList, 10, 0, 1, 3);
        content.add(totalButton, 10, 4);
        content.add(delteButton, 10, 5);
        content.setStyle("-fx-background-image: url('https://ak.picdn.net/shutterstock/videos/3605567/thumb/1.jpg');");
        contentLabel.setStyle("-fx-text-fill: #ffff; -fx-font-weight: bold");
        optionLabel.setStyle("-fx-text-fill: #ffff; -fx-font-weight: bold");
        totalContentLabel.setStyle("-fx-text-fill: #ffff; -fx-font-weight: bold");

        BorderPane layout = new BorderPane();
        layout.setCenter(content);

        shapeList.setOnMouseClicked((event) -> layout.setCenter(sphereView.getView()));

        return layout;
    }
}
