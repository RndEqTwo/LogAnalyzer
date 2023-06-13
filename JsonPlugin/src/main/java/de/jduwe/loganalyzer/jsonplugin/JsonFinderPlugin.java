package de.jduwe.loganalyzer.jsonplugin;

import de.jduwe.loganalyzer.ALogFile;
import de.jduwe.loganalyzer.FinderResult;
import de.jduwe.loganalyzer.LogAnalyzerFinderPlugin;
import de.jduwe.loganalyzer.LogAnalyzerPluginFactory;
import javafx.scene.layout.Region;

public class JsonFinderPlugin implements LogAnalyzerFinderPlugin {
    @Override
    public FinderResult find(ALogFile logFile) {
        return null;
    }

    @Override
    public Region getFinderShowArea() {
        return null;
    }

    @Override
    public String getDisplayName() {
        return "JSON Finder";
    }

    @Override
    public LogAnalyzerPluginFactory getFactoryInstance() {
        return null;
    }

    @Override
    public Region getFilledView() {
        return null;
    }
}
