package org.burrosoft.service;

import org.burrosoft.model.ComicDefinition;
import org.burrosoft.model.ComicType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.util.List;

public class PersistenseService {
    public static final String JDBC_DERBY_COMICDEFINITIONS = "jdbc:derby:comicdefinitions";
    private static final String DERBY_HOME_VAR = "derby.system.home";
    private static final String DERBY_HOME = "/Volumes/Charmeleon/dbtest";
    public static final String COMIC = "COMIC";
    public static final String TITLE = "TITLE";
    public static final String BASEURL = "BASEURL";
    public static final String URLPATTERN = "URLPATTERN";
    public static final String TYPE = "TYPE";
    private SimpleDriverDataSource dataSource;

    public PersistenseService() {
        if (System.getProperty(DERBY_HOME_VAR) == null) {
            System.setProperty(DERBY_HOME_VAR, DERBY_HOME);
        }

        dataSource = new SimpleDriverDataSource();
        dataSource.setDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        dataSource.setUrl(JDBC_DERBY_COMICDEFINITIONS);
    }

    public List<ComicDefinition> loadComicDefinitions() {
        String sql = "SELECT * FROM comicdefinitions.comicdefinition";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<ComicDefinition> comicDefinitionsList = jdbcTemplate.query(
                sql,
                (resultSet, i) -> {
                    ComicDefinition comicDefinition = new ComicDefinition();
                    comicDefinition.setComic(resultSet.getString(COMIC));
                    comicDefinition.setTitle(resultSet.getString(TITLE));
                    comicDefinition.setBaseUrl(resultSet.getString(BASEURL));
                    comicDefinition.setUrlPattern(resultSet.getString(URLPATTERN));
                    comicDefinition.setType(ComicType.valueOf(resultSet.getString(TYPE)));
                    return comicDefinition;
                });
        return comicDefinitionsList;
    }

    public void createComicDefinition(ComicDefinition comicDefinition) {
        String sql =
                String.format("INSERT INTO comicdefinitions.comicdefinition(comic, title, baseurl, urlpattern, type) " +
                                "VALUES('%1', '%2', '%3', '%4', '%5')",
                        comicDefinition.getComic(),
                        comicDefinition.getTitle(),
                        comicDefinition.getBaseUrl(),
                        comicDefinition.getUrlPattern(),
                        comicDefinition.getType().toString());

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int createdRows = jdbcTemplate.update(sql);
        System.out.println("Created rows: " + createdRows);
    }
}
