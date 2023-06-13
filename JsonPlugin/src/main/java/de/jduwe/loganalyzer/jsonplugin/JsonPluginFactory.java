package de.jduwe.loganalyzer.jsonplugin;

import de.jduwe.loganalyzer.LogAnalyzerFilterPlugin;
import de.jduwe.loganalyzer.LogAnalyzerFinderPlugin;
import de.jduwe.loganalyzer.LogAnalyzerPluginFactory;
import javafx.scene.layout.Region;
import org.pf4j.Extension;

@Extension
public class JsonPluginFactory implements LogAnalyzerPluginFactory {
    private ConfigView lastUsedView;

    @Override
    public String getName() {
        return "Json Plugin";
    }

    @Override
    public String getVersion() {
        return "0.0.1";
    }

    @Override
    public String getDescription() {
        return "Ein Json Plugin";
    }

    @Override
    public boolean isFilter() {
        return true;
    }

    @Override
    public boolean isFinder() {
        return true;
    }

    @Override
    public Region createView() {
        lastUsedView = new ConfigView();
        return lastUsedView;
    }

    @Override
    public LogAnalyzerFilterPlugin createFilterPlugin() {
        return new JsonFilterPlugin();
    }

    @Override
    public LogAnalyzerFinderPlugin createFinderPlugin() {
        return null;
    }
}
