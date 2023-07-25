package de.jduwe.loganalyzer.loglevelplugin;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LogLevel {
    private String name;
    private StringProperty filterText;
    private BooleanProperty selected;

    public LogLevel(String name) {
        this.name = name;
        filterText = new SimpleStringProperty(name.toUpperCase());
        selected = new SimpleBooleanProperty(false);
    }

    public String getName() {
        return name;
    }

    public StringProperty filterTextProperty() {
        return filterText;
    }

    public BooleanProperty selectedProperty() {
        return selected;
    }
}
