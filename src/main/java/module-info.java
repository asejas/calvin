module org.burrosoft {
    requires javafx.controls;
    requires javafx.web;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires org.jsoup;
    exports org.burrosoft;
    exports org.burrosoft.model;
    exports org.burrosoft.controller;
}