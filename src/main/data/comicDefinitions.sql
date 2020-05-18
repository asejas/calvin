SET SCHEMA COMICDEFINITIONS;
CREATE TABLE comicdefinition(
    comic VARCHAR(30) NOT NULL PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    baseurl VARCHAR(250) NOT NULL,
    urlpattern VARCHAR(30),
    type VARCHAR(10) NOT NULL
);

INSERT INTO comicdefinition(comic, title, baseurl, urlpattern, type) VALUES('CalvinAndHobbes', 'Calvin and Hobbes', 'https://www.gocomics.com/calvinandhobbes', 'yyyy/MM/dd', 'GOCOMICS');
INSERT INTO comicdefinition(comic, title, baseurl, urlpattern, type) VALUES('Peanuts', 'Peanuts', 'https://www.gocomics.com/peanuts', 'yyyy/MM/dd', 'GOCOMICS');
INSERT INTO comicdefinition(comic, title, baseurl, urlpattern, type) VALUES('Lio', 'Lio', 'https://www.gocomics.com/lio', 'yyyy/MM/dd', 'GOCOMICS');
INSERT INTO comicdefinition(comic, title, baseurl, urlpattern, type) VALUES('Garfield', 'Garfield', 'https://www.gocomics.com/garfield', 'yyyy/MM/dd', 'GOCOMICS');
