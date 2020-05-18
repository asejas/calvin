package org.burrosoft;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.burrosoft.business.AppManager;
import org.burrosoft.business.GUIComposer;
import org.burrosoft.model.ComicDefinition;
import org.burrosoft.service.PersistenseService;

import java.io.IOException;
import java.util.Map;

/**
 * JavaFX App
 */
public class App extends Application {
    private final static GUIComposer guiComposer = new GUIComposer();
    @Override
    public void start(Stage stage) throws IOException {
        guiComposer.startGUI(stage);
    }


    public static void main(String[] args) {
        launch(args);
    }


}