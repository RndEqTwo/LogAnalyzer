package de.jduwe.loganalyzer;

public interface ILogAnalyzerFilter {

    String getDisplayName();
    boolean filter(String line);
}
