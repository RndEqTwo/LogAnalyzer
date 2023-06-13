package de.jduwe.loganalyzer;

import javafx.scene.layout.Region;
import org.pf4j.ExtensionPoint;

public interface LogAnalyzerPlugin extends ExtensionPoint {
    String getDisplayName();
    LogAnalyzerPluginFactory getFactoryInstance();

    Region getFilledView();

}
