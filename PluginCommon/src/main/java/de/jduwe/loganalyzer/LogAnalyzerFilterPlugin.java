package de.jduwe.loganalyzer;

public interface LogAnalyzerFilterPlugin extends LogAnalyzerPlugin{

    ALogFile filter(ALogFile logFile);
}
