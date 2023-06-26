package de.jduwe.loganalyzer;

import javafx.scene.layout.Region;
import org.pf4j.ExtensionPoint;

public interface ILogAnalyzerPlugin extends ExtensionPoint {

    String getDisplayName();
    ILogAnalyzerPluginFactory getFactoryInstance();

    Region getFilledView();

}
