package gradle_proyek.Scene;

import gradle_proyek.Models.BMI;
import gradle_proyek.helpers.Color;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class mainMenuScene extends SceneUtama {
    private double height;
    private double berat;

    public mainMenuScene(Stage stageUtama, double height, double berat) {
        super(stageUtama);
        this.height = height;
        this.berat = berat;
    }

    @Override
    public Scene getScene() {
        BMI bmi = kalkulasi(height, berat);
        Label judul = new Label("Hasil Kalkulasi BMI");

        Label hasil = new Label(String.format("%.2f", bmi.getBmi()));
        hasil.setWrapText(true);
        hasil.setTextAlignment(TextAlignment.CENTER);
        hasil.getStyleClass().add("newClass");

        Label result = new Label(bmi.getSaran());
        result.setWrapText(true);
        result.setTextAlignment(TextAlignment.CENTER);
        result.getStyleClass().add("newClass");

        Button btnBack = new Button("Back To Home");
        btnBack.setOnAction(event -> stageUtama.setScene(new inputScene(stageUtama).getScene()));

        VBox vbox = new VBox();
        vbox.getChildren().addAll(judul, hasil, result, btnBack);
        vbox.setAlignment(Pos.CENTER);

        ImageView imageView = new ImageView("/Image/logoScene3.png");
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(vbox);

        StackPane pane = new StackPane(imageView, hbox);

        Scene scene = new Scene(pane, 288, 512);
        scene.getStylesheets().add(getClass().getResource("/Style/style.css").toExternalForm());
        return scene;
    }

    private BMI kalkulasi(double height, double berat) {
        height = height / 100;
        BMI bmi = new BMI();
        bmi.setBmi(berat / (height * height));
        if (bmi.getBmi() < 18.5) {
            bmi.setSaran("Berat badan kurang, disarankan pertahankan pola makan dan konsumsi makanan bernutrisi");
            bmi.setWarna(Color.Blue);
        } else if (bmi.getBmi() >= 18.5 && bmi.getBmi() < 25) {
            bmi.setSaran("Berat badan normal, pertahankan pola makan  ");
            bmi.setWarna(Color.Green);
        } else if (bmi.getBmi() >= 25 && bmi.getBmi() < 30) {
            bmi.setSaran("berat badan berlebih, kurangi makanan tinggi lemak dan gula ");
            bmi.setWarna(Color.Red);
        } else {
            bmi.setSaran("mengalami obesitas, segera konsul kepada dokter untuk penanganan lebih lanjut");
            bmi.setWarna(Color.Ungu);
        }
        return bmi;
    }
}
