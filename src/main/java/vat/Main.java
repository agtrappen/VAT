package vat;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import vat.ui.MainUI;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        MainUI mainView = new MainUI();

        BorderPane layout = new BorderPane();

        layout.setCenter(mainView.getView());
        Scene view = new Scene(layout, 400, 300);

        stage.setScene(view);
        stage.show();
    }
}
