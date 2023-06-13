package de.jduwe.loganalyzer;

import java.util.List;

public interface FinderResult {
    boolean isVisible(long rowNumber);
    List<AFinderResultEntry> getFilterResultEntries();
}
