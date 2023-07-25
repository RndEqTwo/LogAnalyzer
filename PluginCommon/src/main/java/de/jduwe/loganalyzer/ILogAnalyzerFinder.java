package de.jduwe.loganalyzer;

import javafx.scene.layout.Region;

import java.util.List;

public interface ILogAnalyzerFinder{

    String getDisplayName();
    Region find(List<ILogLine> logFile);
}
