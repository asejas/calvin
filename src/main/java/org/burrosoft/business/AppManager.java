package org.burrosoft.business;

import org.burrosoft.model.ComicDefinition;
import org.burrosoft.model.ComicDefinitions;
import org.burrosoft.service.ComicDefinitionsReader;
import org.burrosoft.service.HTMLReader;
import org.burrosoft.service.PersistenseService;
import org.burrosoft.util.DateUtils;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class AppManager {
    private final static ComicDefinitionsReader comicDefinitionsReader = new ComicDefinitionsReader();
    private final static HTMLReader htmlReader = new HTMLReader();
    private final static DateUtils dateUtils = new DateUtils();

    public ComicDefinitions getComicDefinitions() throws IOException {

        ComicDefinitions comicDefinitions = comicDefinitionsReader.getDefinitions();
        System.out.println("DEFINITIONS: " + comicDefinitionsReader.getAsString(comicDefinitions));
        return comicDefinitions;
    }

    public Map<String, ComicDefinition> getComicDefinitionsMap() throws IOException {
        ComicDefinitions comicDefinitions = comicDefinitionsReader.getDefinitions();
        System.out.println("DEFINITIONS: " + comicDefinitionsReader.getAsString(comicDefinitions));
        Map<String, ComicDefinition> comicDefinitionMap = new HashMap();
        for (ComicDefinition comicDefinition : comicDefinitions.getComicDefinitions()) {
            comicDefinitionMap.put(comicDefinition.getComic(), comicDefinition);
        }
        return comicDefinitionMap;
    }

    public Document getHtmlPage(ComicDefinition comicDefinition) throws IOException {
        return htmlReader.readHTML(comicDefinition.composeURL());
    }

    public Document getHtmlPageForDate(ComicDefinition comicDefinition,
                                       LocalDateTime localDateTime) throws IOException {
        String url=comicDefinition.composeURLForDate(localDateTime);
        System.out.println("URL: "+url);
        return htmlReader.readHTML(url);
    }

    public String getComicImage(Document document){
        return String.format("<img src=\"%s\"/>",htmlReader.getImageUrl(document));
    }

    public String getGeneratedComicPage(Map<String, ComicDefinition> comicDefinitionsMap, String comic)
            throws IOException {
        ComicDefinition comicDefinition=comicDefinitionsMap.get(comic);
        Document document = this.getHtmlPage(comicDefinition);
        return getGeneratedComicForFormattedDate(comicDefinition,
                document,
                LocalDateTime.now());
    }

    public String getGeneratedComicPageForDate(ComicDefinition comicDefinition,
                                               LocalDateTime dateTime) throws IOException {
        Document document = this.getHtmlPageForDate(comicDefinition, dateTime);
        return getGeneratedComicForFormattedDate(comicDefinition,
                document,
                dateTime);
    }
    private String getGeneratedComicForFormattedDate(ComicDefinition comicDefinition,
                                                     Document document,
                                                     LocalDateTime dateTime){
        return "<html>" +
                "<body>" +
                "<p>" +
                "Comic: "+comicDefinition.getTitle()+" <br/>"+
                "Date: "+dateUtils.getFormattedDate(dateTime, comicDefinition.getUrlPattern())+"<br/>"+
                "</p>"+
                getComicImage(document)+
                "</body></html>";
    }
}
