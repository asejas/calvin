package org.burrosoft.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.burrosoft.model.ComicDefinitions;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ComicDefinitionsReader {
    private static final String definitionsPath = "comicDefinitionList.json";
    private static final ObjectMapper mapper = new ObjectMapper();

    public ComicDefinitionsReader() {
    }

    public ComicDefinitions getDefinitions() throws IOException {
        return mapper.readValue(
                Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(definitionsPath)),
                ComicDefinitions.class);
    }

    public String getAsString(ComicDefinitions comicDefinitions) throws JsonProcessingException {
        return mapper.writeValueAsString(comicDefinitions);
    }
}
