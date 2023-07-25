package de.jduwe.loganalyzer;

import javafx.beans.property.SimpleBooleanProperty;

import java.util.Map;

public interface ILogLine {

    String getLineContent();
    int getIndex();
    SimpleBooleanProperty visibility();
    void setLineContent(String lineContent);

    Map<String, String> getLineProperties();

    void appendToLine(String text);

    String getLogInformation(String namedGroup);
    void setLogInformation(String namedGroup, String value);
}
