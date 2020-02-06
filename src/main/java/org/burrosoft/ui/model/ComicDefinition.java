package org.burrosoft.ui.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.burrosoft.model.ComicType;

import java.util.Objects;

public class ComicDefinition {
    private final StringProperty comic = new SimpleStringProperty(
            this, "Comic", "");

    private final StringProperty title = new SimpleStringProperty(
            this, "Title", "");

    private final StringProperty baseUrl = new SimpleStringProperty(
            this, "Base Url", "");

    private final StringProperty urlPattern = new SimpleStringProperty(
            this, "URL Pattern", "");

    private final ObjectProperty<ComicType> comicType = new SimpleObjectProperty<>(
            this, "Comic type", ComicType.GOCOMICS
    );

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ComicDefinition comicDefinition = (ComicDefinition) obj;
        return Objects.equals(comic, comicDefinition.comic) &&
                Objects.equals(title, comicDefinition.title) &&
                Objects.equals(baseUrl, comicDefinition.baseUrl) &&
                Objects.equals(urlPattern, comicDefinition.urlPattern) &&
                Objects.equals(comicType, comicDefinition.comicType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comic, title, baseUrl, urlPattern, comicType);
    }
}
