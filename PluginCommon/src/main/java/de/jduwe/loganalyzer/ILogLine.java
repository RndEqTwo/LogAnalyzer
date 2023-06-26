package de.jduwe.loganalyzer;

import javafx.beans.property.SimpleBooleanProperty;

public interface ILogLine {

    String getLineContent();
    int getIndex();
    SimpleBooleanProperty visibility();
}
