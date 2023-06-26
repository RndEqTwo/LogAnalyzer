package de.jduwe.loganalyzer;

public interface ILogAnalyzerFilterPlugin extends ILogAnalyzerPlugin {

    boolean filter(String line);
}
