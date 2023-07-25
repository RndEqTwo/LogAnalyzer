package de.jduwe.loganalyzer;

import javafx.scene.layout.Region;
import org.pf4j.ExtensionPoint;

import java.util.Properties;

public interface ILogAnalyzerPlugin extends ExtensionPoint {
    String getName();
    String getVersion();
    String getDescription();

    void setEventManager(IEventManager eventManager);
    void setProperties(Properties properties);

    boolean isFilter();
    boolean isFinder();

    Region createSettingsView();

    ILogAnalyzerFilter createFilter();
    ILogAnalyzerFinder createFinder();
}
