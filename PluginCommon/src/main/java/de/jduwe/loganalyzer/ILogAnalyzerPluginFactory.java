package de.jduwe.loganalyzer;

import javafx.scene.layout.Region;
import org.pf4j.ExtensionPoint;

public interface ILogAnalyzerPluginFactory extends ExtensionPoint {
    String getName();
    String getVersion();
    String getDescription();
    void setEventManager(IEventManager eventManager);

    boolean isFilter();
    boolean isFinder();

    Region createView();

    ILogAnalyzerFilterPlugin createFilterPlugin();
    ILogAnalyzerFinderPlugin createFinderPlugin();

}
