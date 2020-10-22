package vat.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderRepeat;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//Application
public class MainUI {
    private Stage shapeStage;
    private BorderPane layout;

    public MainUI(){
        GridPane content = new GridPane();
        SphereUI sphereView = new SphereUI();
        BlockUI blockView = new BlockUI();
        ConeUI coneView = new ConeUI();
        CylinderUI cylinderView = new CylinderUI();
        PyramidUI pyramidView = new PyramidUI();

//      Set borderpanes
        BorderPane blockLayout = new BorderPane();
        blockLayout.setCenter(blockView.getView());

        BorderPane coneLayout = new BorderPane();
        coneLayout.setCenter(coneView.getView());

        BorderPane cylinderLayout = new BorderPane();
        cylinderLayout.setCenter(cylinderView.getView());

        BorderPane pyramidLayout = new BorderPane();
        pyramidLayout.setCenter(pyramidView.getView());

        BorderPane sphereLayout = new BorderPane();
        sphereLayout.setCenter(sphereView.getView());


//      Set scenes
        Scene blockScene = new Scene(blockLayout, 400, 300);
        Scene coneScene = new Scene(coneLayout, 400, 300);
        Scene cylinderScene = new Scene(cylinderLayout, 400, 300);
        Scene pyramidScene = new Scene(pyramidLayout, 400, 300);
        Scene sphereScene = new Scene(sphereLayout, 400, 300);

//      Set stage
        this.shapeStage = new Stage();

        // Shape option
        Label optionLabel = new Label("Vorm");
        ObservableList<String> options = FXCollections.observableArrayList ("Sphere", "Block", "Cylinder", "Cone", "Pyramid");
        ComboBox<String> shapeOptions = new ComboBox<String>();
        shapeOptions.setItems(options);

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
                "Sphere", "Block", "Cylinder", "Cone", "Pyramid");
        shapeList.setItems(items);
        shapeList.setMaxHeight(200);

        // Total content button
        Button totalButton = new Button("Totale inhoud");

        // Delete shape button
        Button deleteButton = new Button("Verwijder Vorm");

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
        content.add(deleteButton, 10, 5);
        content.setStyle("-fx-background-image: url('https://ak.picdn.net/shutterstock/videos/3605567/thumb/1.jpg');");
        contentLabel.setStyle("-fx-text-fill: #ffff; -fx-font-weight: bold");
        optionLabel.setStyle("-fx-text-fill: #ffff; -fx-font-weight: bold");
        totalContentLabel.setStyle("-fx-text-fill: #ffff; -fx-font-weight: bold");

        this.layout = new BorderPane();
        layout.setCenter(content);

//      Get select item from the shapelist
        shapeList.setOnMouseClicked((event)->{
            String selectedItem = shapeList.getSelectionModel().getSelectedItem();
            switch(selectedItem){
                case "Sphere":
                    this.shapeStage.setScene(sphereScene);
                    this.shapeStage.show();
                    break;
                case "Block":
                    this.shapeStage.setScene(blockScene);
                    this.shapeStage.show();
                    break;
                case "Cone":
                    this.shapeStage.setScene(coneScene);
                    this.shapeStage.show();
                    break;
                case "Cylinder":
                    this.shapeStage.setScene(cylinderScene);
                    this.shapeStage.show();
                    break;
                case "Pyramide":
                    this.shapeStage.setScene(pyramidScene);
                    this.shapeStage.show();
                    break;
                default:
                    System.out.println("Selected unsupported item" + selectedItem);
            }
        });
    }


    public Parent getView() {
//        Locatie van listeners
        return this.layout;
    }
}