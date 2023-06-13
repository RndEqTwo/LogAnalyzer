package de.jduwe.loganalyzer;

import javafx.scene.layout.Region;

public interface LogAnalyzerFinderPlugin extends LogAnalyzerPlugin {

    FinderResult find(ALogFile logFile);

    Region getFinderShowArea();
}
