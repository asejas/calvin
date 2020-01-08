package org.burrosoft.controller;

import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.web.WebView;
import org.burrosoft.business.AppManager;
import org.burrosoft.model.ComicDefinition;
import org.burrosoft.util.DateUtils;
import org.jsoup.helper.StringUtil;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

import static org.burrosoft.util.DateUtils.DEFAULT_DATE_FORMAT;

public class MainViewController {
    public ComboBox<String> comboBoxComic = null;
    public Label labelDate = null;
    public WebView webViewComic = null;
    public Button buttonExit = null;
    public Button buttonPrevious = null;
    public Button buttonNext = null;
    private static LocalDateTime currentDate;

    private AppManager appManager = new AppManager();
    private Map<String, ComicDefinition> comicDefinitionsMap;
    private DateUtils dateUtils = new DateUtils();

    public MainViewController() {
        currentDate = LocalDateTime.now();
        try {
            comicDefinitionsMap = appManager.getComicDefinitionsMap();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        comboBoxComic.setItems(FXCollections
                .observableArrayList(
                        comicDefinitionsMap.keySet())
        );
        labelDate.setText(dateUtils.getFormattedCurrentDate(DEFAULT_DATE_FORMAT));
    }

    @FXML
    public void buttonExitClicked(Event e) {
        System.out.println("Exit!");
        System.exit(1);
    }

    @FXML
    public void buttonPreviousClicked(Event e) {
        currentDate = currentDate.minusDays(1);
        updateComicView();
    }

    @FXML
    public void buttonNextClicked(Event e) {
        currentDate = currentDate.plusDays(1);
        updateComicView();
    }

    @FXML
    public void comboBoxComicSelected(Event e) {
        currentDate = LocalDateTime.now();
        updateComicView();
    }

    private void updateComicView(){
        String comicSelected = this.comboBoxComic.getValue();
        System.out.println("ComicSelected: " + comicSelected);
        if(StringUtil.isBlank(comicSelected)){
            webViewComic.getEngine().loadContent("<HTML/>");
        }
        else {
            try {
                String htmlContent = appManager.getGeneratedComicPageForDate(comicDefinitionsMap,
                        comicDefinitionsMap.get(comicSelected).getComic(),
                        currentDate);
                System.out.println("HTML loaded! .. " + htmlContent);
                webViewComic.getEngine().loadContent(htmlContent);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
