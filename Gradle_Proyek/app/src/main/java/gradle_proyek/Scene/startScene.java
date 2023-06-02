package gradle_proyek.Scene;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class startScene extends SceneUtama {
    public startScene(Stage stageUtama) {
        super(stageUtama);
    }

    @Override
    public Scene getScene() {
        ImageView logoImage1 = new ImageView("/Image/logoScene1.png");
        logoImage1.setFitHeight(512);
        logoImage1.setFitWidth(320);

        Button starButton = new Button("Start");
        starButton.setId("start");
        starButton.setOnAction(event -> stageUtama.setScene(new inputScene(stageUtama).getScene()));

        VBox vbox = new VBox(1000);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().add(starButton);
        StackPane pane = new StackPane(logoImage1, vbox);

        Scene scene = new Scene(pane, 320, 512);
        scene.getStylesheets().add(getClass().getResource("/Style/style.css").toExternalForm());
        return scene;
    }
}