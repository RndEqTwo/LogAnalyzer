package de.jduwe.loganalyzer;

import javafx.beans.property.SimpleBooleanProperty;

import java.util.HashMap;
import java.util.Map;

public class LogLine implements ILogLine {

    private String logEntry;
    private int index;
    private SimpleBooleanProperty isVisible;
    private Map<String, String> lineProperties;
    private String contentGroupName;

    public LogLine(String logEntry, int index, String contentGroupName) {
        this.logEntry = logEntry;
        this.index = index;
        this.lineProperties = new HashMap<>();
        this.contentGroupName = contentGroupName;
        isVisible = new SimpleBooleanProperty();
        isVisible.set(true);
    }

    @Override
    public String getLineContent() {
        return logEntry;
    }

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public SimpleBooleanProperty visibility() {
        return isVisible;
    }

    @Override
    public void setLineContent(String lineContent) {
        logEntry = lineContent;
    }

    @Override
    public Map<String, String> getLineProperties() {
        return lineProperties;
    }

    @Override
    public String toString() {
        return logEntry;
    }

    @Override
    public String getLogInformation(String namedGroup){
        return lineProperties.get(namedGroup);
    }

    @Override
    public void setLogInformation(String namedGroup, String value) {
        lineProperties.put(namedGroup, value);
    }

    @Override
    public void appendToLine(String text){
        String preparedLine = text.replace("\\s+", "");
        logEntry += preparedLine;
        lineProperties.put(contentGroupName, lineProperties.get(contentGroupName) + preparedLine);
    }
}
