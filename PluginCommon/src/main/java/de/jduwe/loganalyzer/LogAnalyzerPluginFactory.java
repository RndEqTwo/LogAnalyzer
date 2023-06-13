package de.jduwe.loganalyzer;

import javafx.scene.layout.Region;
import org.pf4j.ExtensionPoint;

public interface LogAnalyzerPluginFactory extends ExtensionPoint {
    String getName();
    String getVersion();
    String getDescription();

    boolean isFilter();
    boolean isFinder();

    Region createView();

    LogAnalyzerFilterPlugin createFilterPlugin();
    LogAnalyzerFinderPlugin createFinderPlugin();

}
