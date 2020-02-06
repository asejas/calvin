package org.burrosoft.business;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.burrosoft.model.ComicDefinitions;

import java.io.IOException;
import java.util.Objects;

public class ComicDefinitionsReader {
    private static final String definitionsPath = "comicDefinitionList.json";
    private static final ObjectMapper mapper = new ObjectMapper();
    private static ComicDefinitions definitions;

    public ComicDefinitionsReader() {
    }

    public ComicDefinitions getDefinitions() throws IOException {
        if (definitions == null) {
            definitions = mapper.readValue(
                    Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(definitionsPath)),
                    ComicDefinitions.class);
        }
        System.out.println("Comic definitions: " + mapper.writeValueAsString(definitions));
        return definitions;
    }

}
