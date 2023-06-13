package de.jduwe.loganalyzer.stringplugin;

import de.jduwe.loganalyzer.AFinderResultEntry;

public class StringFinderResultEntry extends AFinderResultEntry {

    public StringFinderResultEntry(int startLineNumber, int endLineNumber) {
        super(startLineNumber, endLineNumber);
    }

    @Override
    public String toString() {
        return getDisplayText();
    }
}
