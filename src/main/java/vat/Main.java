package vat;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import vat.ui.AddCylinderUI;
import vat.ui.MainUI;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        MainUI mainView = new MainUI();
        AddCylinderUI cylinderView = new AddCylinderUI();

        BorderPane layout = new BorderPane();

        layout.setCenter(cylinderView.getView());
        Scene view = new Scene(layout, 400, 300);

        stage.setScene(view);
        stage.show();
    }
}