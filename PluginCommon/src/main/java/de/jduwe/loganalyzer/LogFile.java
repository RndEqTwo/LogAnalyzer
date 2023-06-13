package de.jduwe.loganalyzer;

import java.util.List;

public interface LogFile {
    List<String> getLines();
    List<String> getOriginalText();
}
