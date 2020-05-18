package org.burrosoft.service;

import org.burrosoft.model.ComicDefinition;

public class ComicDefinitionsSaver {
    public void saveComicDefinition(ComicDefinition comicDefinition){
        PersistenseService persistenseService=new PersistenseService();
        persistenseService.createComicDefinition(comicDefinition);
    }
}
