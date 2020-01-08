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

import java.io.IOException;
import java.util.Map;

/**
 * JavaFX App
 */
public class App extends Application {
    private final static AppManager appManager = new AppManager();
    private final static GUIComposer guiComposer = new GUIComposer();
    @Override
    public void start(Stage stage) throws IOException {
        /*stage=new Stage(StageStyle.DECORATED);
        Map<String, ComicDefinition> comicDefinitionsMap = appManager.getComicDefinitionsMap();
        VBox vBox = new VBox();
        for (String key : comicDefinitionsMap.keySet()) {
            WebView webView = new WebView();
            String htmlContent = appManager.getGeneratedComicPage(comicDefinitionsMap, comicDefinitionsMap.get(key).getComic());
            webView.getEngine().loadContent(htmlContent);
            vBox.getChildren().add(webView);
        }
        stage.initStyle(StageStyle.DECORATED);
        setUserAgentStylesheet(STYLESHEET_CASPIAN);
        Scene scene = new Scene(vBox, 930, 900);
        stage.setScene(scene);
        stage.setTitle("Comics1.0");
        stage.sizeToScene();
        stage.show();*/
        guiComposer.startGUI(stage);
    }



    public static void main(String[] args) throws IOException {
        launch(args);
    }


}