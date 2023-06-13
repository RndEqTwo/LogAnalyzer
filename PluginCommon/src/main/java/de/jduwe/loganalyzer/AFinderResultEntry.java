package de.jduwe.loganalyzer;

public abstract class AFinderResultEntry implements FinderResultEntry{

    protected int startLineNumber;
    protected int endLineNumber;

    public AFinderResultEntry(int startLineNumber, int endLineNumber) {
        this.startLineNumber = startLineNumber;
        this.endLineNumber = endLineNumber;
    }

    @Override
    public String getDisplayText() {
        return "Ergebnis: " + startLineNumber + " - " + endLineNumber;
    }

    @Override
    public int getStartLineNumber() {
        return startLineNumber;
    }

    @Override
    public int getEndLineNumber() {
        return endLineNumber;
    }
}
