/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package gradle_proyek;

import gradle_proyek.Models.BMI;
import gradle_proyek.helpers.Color;
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

        Button submit = new Button("Kalkulasi");

        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(label, height, textTinggi, lebar, textBeratBadan, submit);

        ImageView imageView = new ImageView("/Image/logoScene3.png");

        StackPane pane = new StackPane(imageView, vbox);
        Scene scene = new Scene(pane, 320, 512);

        submit.setOnAction(event -> {
            double berat = Double.parseDouble(textBeratBadan.getText());
            double tinggi = Double.parseDouble(textTinggi.getText());
            stageUtama.setScene(mainMenuScene(tinggi, berat));

        });
        return scene;
    }

    private Scene mainMenuScene(double height, double berat) {
        BMI bmi = kalkulasi(height, berat);
        Label judul = new Label("Hasil Kalkulasi BMI");
        Label hasil = new Label(String.format("%.2f", bmi.getBmi()));
        hasil.setWrapText(true);
        hasil.setTextAlignment(TextAlignment.CENTER);

        Label result = new Label(bmi.getSaran());
        result.setWrapText(true);
        result.setTextAlignment(TextAlignment.CENTER);

        Button btnBack = new Button("Back To Home");

        VBox vbox = new VBox();
        vbox.getChildren().addAll(judul, hasil, result, btnBack);
        vbox.setAlignment(Pos.CENTER);

        ImageView imageView = new ImageView("/Image/logoScene2.png");
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(vbox);

        Scene scene = new Scene(null, 320, 512);
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
