package de.jduwe.loganalyzer;

import javafx.beans.property.SimpleBooleanProperty;

public class LogLine implements ILogLine {

    private String logEntry;
    private int index;
    private SimpleBooleanProperty isVisible;

    public LogLine(String logEntry, int index) {
        this.logEntry = logEntry;
        this.index = index;
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
    public String toString() {
        return logEntry;
    }
}
