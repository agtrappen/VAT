package vat;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import vat.ui.BlockUI;
import vat.ui.CylinderUI;
import vat.ui.MainUI;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        MainUI mainView = new MainUI();
        CylinderUI cylinderView = new CylinderUI();
        BlockUI blockView = new BlockUI();

        BorderPane layout = new BorderPane();

        layout.setCenter(blockView.getView());
        Scene view = new Scene(layout, 400, 300);
        stage.setTitle("VAT");

        stage.setScene(view);
        stage.show();
    }
}
