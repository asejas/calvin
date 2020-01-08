package org.burrosoft.model;

import org.burrosoft.util.DateUtils;

import java.time.LocalDateTime;

public class ComicDefinition {
    public static final String SLASH = "/";
    private String comic;
    private String title;
    private String baseUrl;
    private String urlPattern;
    private ComicType type;
    private DateUtils dateUtils = new DateUtils();

    public ComicDefinition() {
    }

    public String getComic() {
        return comic;
    }

    public void setComic(String comic) {
        this.comic = comic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getUrlPattern() {
        return urlPattern;
    }

    public void setUrlPattern(String urlPattern) {
        this.urlPattern = urlPattern;
    }

    public ComicType getType() {
        return type;
    }

    public void setType(ComicType type) {
        this.type = type;
    }

    public String composeURL() {
        return this.baseUrl + SLASH + dateUtils.getFormattedCurrentDate(this.getUrlPattern());
    }

    public String composeURLForDate(LocalDateTime localDateTime) {
        return this.baseUrl + SLASH + dateUtils.getFormattedDate(localDateTime, this.getUrlPattern());
    }

}
