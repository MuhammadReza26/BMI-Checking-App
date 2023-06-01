/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package gradle_proyek;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class App extends Application {
    private Stage stageUtama;

    public void start(Stage stageUtama) {
        this.stageUtama = stageUtama;
        startScene();
        stageUtama.setResizable(false);
        stageUtama.setTitle("Aplikasi BMI Checking");
        stageUtama.show();
    }

    private Scene startScene() {
        ImageView logoImage1 = new ImageView("/Image/logoScene1.png");
        logoImage1.setFitHeight(512);
        logoImage1.setFitWidth(320);

        Button starButton = new Button("Start");
        starButton.setId("start");
        starButton.setOnAction(event -> stageUtama.setScene(inputScene()));

        VBox vbox = new VBox(1000);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().add(starButton);
        StackPane pane = new StackPane(logoImage1, vbox);

        Scene scene = new Scene(pane, 320, 512);
        return scene;
    }
    private Scene inputScene() {
        Label label = new Label("BMI Checking ");
        Label height = new Label("Tinggi Badan (Cm)");
        TextField textTinggi = new TextField();
        Label lebar = new Label("Berat Badan (Kg)");
        TextField textBeratBadan = new TextField();
        
        return scene;
}
}
