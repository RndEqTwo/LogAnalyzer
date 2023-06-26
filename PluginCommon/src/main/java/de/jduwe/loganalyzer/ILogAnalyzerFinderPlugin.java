package de.jduwe.loganalyzer;

import javafx.scene.layout.Region;

import java.util.List;

public interface ILogAnalyzerFinderPlugin extends ILogAnalyzerPlugin {

    Region find(List<ILogLine> logFile);
}
