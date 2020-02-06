package org.burrosoft;

import javafx.application.Application;
import javafx.stage.Stage;
import org.burrosoft.ui.GUIComposer;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {
    private final static GUIComposer guiComposer = new GUIComposer();

    @Override
    public void start(Stage stage) throws IOException {
        guiComposer.startGUI(stage);
    }


    public static void main(String[] args){
        launch(args);
    }


}