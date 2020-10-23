package vat;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import vat.database.JDBCUtil;
import vat.ui.Applicatie;

//        Naar applicatie
//        CylinderUI cylinderView = new CylinderUI();
//        SphereUI blockView = new SphereUI();

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        JDBCUtil db = new JDBCUtil();
        Applicatie mainView = new Applicatie();

        BorderPane layout = new BorderPane();

        layout.setCenter(mainView.getView());
        Scene view = new Scene(layout, 400, 300);
        stage.setTitle("VAT");

        stage.setScene(view);
        stage.show();
    }
}
