package gradle_proyek.Scene;

import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class SceneUtama {

    protected Stage stageUtama;

    public SceneUtama(Stage stageUtama) {
        this.stageUtama = stageUtama;
    }

    public abstract Scene getScene();
}
