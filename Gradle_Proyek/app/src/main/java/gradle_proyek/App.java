package gradle_proyek;

import gradle_proyek.Scene.SceneUtama;
import gradle_proyek.Scene.startScene;
import javafx.application.Application;

import javafx.stage.Stage;

public class App extends Application {
    private Stage stageUtama;
    private SceneUtama sceneSekarang;

    public void start(Stage stageUtama) {
        this.stageUtama = stageUtama;
        stageUtama.setTitle("Aplikasi BMI Checking");
        stageUtama.setResizable(false);
        stageUtama.setScene(new startScene(stageUtama).getScene());
        stageUtama.show();
    }

    public void setScene(SceneUtama scene) {
        sceneSekarang = scene;
        stageUtama.setScene(sceneSekarang.getScene());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
