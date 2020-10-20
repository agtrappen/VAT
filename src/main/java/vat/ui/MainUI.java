package vat.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class MainUI {
    public Parent getView() {
        GridPane layout = new GridPane();
        // Shape options
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

        // Styling
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        // Set components
        layout.add(optionLabel, 0, 0);
        layout.add(shapeOptions, 0, 1);
        layout.add(contentLabel, 0, 2);
        layout.add(contentField, 0, 3);
        layout.add(totalContentLabel, 0, 4);
        layout.add(totalContentField, 0, 5);
        layout.add(saveButton, 0, 7);
        layout.add(loadButton, 0, 8);
        layout.add(shapeList, 4, 0);

        return layout;
    }
}
