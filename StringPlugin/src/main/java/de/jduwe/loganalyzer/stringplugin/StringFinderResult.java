package de.jduwe.loganalyzer.stringplugin;

import de.jduwe.loganalyzer.AFinderResultEntry;
import de.jduwe.loganalyzer.FinderResult;

import java.util.List;

public class StringFinderResult implements FinderResult {

    private List<AFinderResultEntry> entries;

    public StringFinderResult(List<AFinderResultEntry> entries) {
        this.entries = entries;
    }

    @Override
    public boolean isVisible(long rowNumber) {
        return false;
    }

    @Override
    public List<AFinderResultEntry> getFilterResultEntries() {
        return entries;
    }
}
