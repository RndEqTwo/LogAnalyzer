package de.jduwe.loganalyzer;

import java.util.List;

public class ALogFile  implements LogFile{
    private List<String> originalText;
    private List<String> lines;

    public ALogFile(List<String> text) {
        this.lines = text;
        this.originalText = text;
    }

    @Override
    public List<String> getLines() {
        return lines;
    }

    @Override
    public List<String> getOriginalText() {
        return originalText;
    }
}
