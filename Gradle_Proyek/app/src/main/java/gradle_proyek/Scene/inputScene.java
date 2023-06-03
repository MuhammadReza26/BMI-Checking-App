package gradle_proyek.Scene;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class inputScene extends SceneUtama {
    public inputScene(Stage stageUtama) {
        super(stageUtama);
    }

    @Override
    public Scene getScene() {
        Label label = new Label("BMI Checking ");
        label.getStyleClass().add("label");

        Label height = new Label("Tinggi Badan (Cm)");
        height.getStyleClass().add("label");
        TextField textTinggi = new TextField();
        textTinggi.setAlignment(Pos.CENTER);
        textTinggi.getStyleClass().add("kolom");

        Label lebar = new Label("Berat Badan (Kg)");
        lebar.getStyleClass().add("label");
        TextField textBeratBadan = new TextField();
        textBeratBadan.setAlignment(Pos.CENTER);
        textBeratBadan.getStyleClass().add("kolom");

        Button submit = new Button("Kalkulasi");
        submit.setId("kalkulasi");

        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.BOTTOM_CENTER);
        vbox.getChildren().addAll(label, height, textTinggi, lebar, textBeratBadan, submit);

        ImageView imageView = new ImageView("/Image/logoScene2.png");
        StackPane pane = new StackPane(imageView, vbox);

        Scene scene = new Scene(pane, 280, 512);
        scene.getStylesheets().add(getClass().getResource("/Style/style.css").toExternalForm());

        submit.setOnAction(event -> {
            double berat = Double.parseDouble(textBeratBadan.getText());
            double tinggi = Double.parseDouble(textTinggi.getText());
            stageUtama.setScene(new mainMenuScene(stageUtama, tinggi, berat).getScene());
        });

        return scene;
    }
}
