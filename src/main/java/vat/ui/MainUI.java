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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//Application
public class MainUI {
    private Button saveButton;
    private Button loadButton;
    private Button totalButton;
    private Button delteButton;
    private BorderPane layout;
    private GridPane content;
    private SphereUI sphereView;
    private Label optionLabel;
    private Label contentLabel;
    private ObservableList<String> options;
    private ComboBox shapeOptions;
    private TextField contentField;
    private Label totalContentLabel;
    private TextField totalContentField;
    private ListView<String> shapeList;
    private ObservableList<String> items;

    public MainUI(){
        this.content = new GridPane();
        this.sphereView = new SphereUI();

        // Shape option
        this.optionLabel = new Label("Vorm");
        this.options = FXCollections.observableArrayList ("Sphere", "Block", "Cylinder", "Cone", "Pyramid");
        this.shapeOptions = new ComboBox(options);

        // Content shape
        this.contentLabel = new Label("Inhoud");
        this.contentField = new TextField();

        // Total content shape
        this.totalContentLabel = new Label("Totale inhoud");
        this.totalContentField = new TextField();

        // Left action buttons
        this.saveButton = new Button("Opslaan");
        this.loadButton = new Button("Laad");

        // Shape list
        this.shapeList = new ListView<String>();
        this.items =FXCollections.observableArrayList (
                "Sphere", "Block", "Cylinder", "Cone", "Pyramid");
        shapeList.setItems(items);
        shapeList.setMaxHeight(200);

        // Total content button
        this.totalButton = new Button("Totale inhoud");

        // Delete shape button
        this.delteButton = new Button("Verwijder Vorm");

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

        this.layout = new BorderPane();
        layout.setCenter(content);

//        TODO:MouseClickevent op items in de shapelist


        shapeList.setOnMouseClicked((event)->{
            System.out.println(shapeList.getSelectionModel().getSelectedIndices());
        });

//        shapeList.setOnMouseClicked((event)->{
//            if(event.equals("block")){
//                layout.setCenter(sphereView.getView());
//            }
////            layout.setCenter(sphereView.getView());
//        });
//        shapeList.setOnMouseClicked((event) -> {
//            if (event.equals())
//            layout.setCenter(sphereView.getView())
//                });


    }


    public Parent getView() {
//        Locatie van listeners


        return this.layout;
    }
}
