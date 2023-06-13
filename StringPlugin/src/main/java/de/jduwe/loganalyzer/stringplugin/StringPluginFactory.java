package de.jduwe.loganalyzer.stringplugin;

import de.jduwe.loganalyzer.LogAnalyzerFilterPlugin;
import de.jduwe.loganalyzer.LogAnalyzerFinderPlugin;
import de.jduwe.loganalyzer.LogAnalyzerPluginFactory;
import javafx.scene.layout.Region;
import org.pf4j.Extension;

@Extension
public class StringPluginFactory implements LogAnalyzerPluginFactory {

    private ConfigView configView;

    @Override
    public String getName() {
        return "String Plugin";
    }

    @Override
    public String getVersion() {
        return "0.0.1";
    }

    @Override
    public String getDescription() {
        return "Dieses Plugin filtert jede Zeile heraus die nicht den konfigurierbaren String enthält";
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
        configView = new ConfigView();
        return configView;
    }

    @Override
    public LogAnalyzerFilterPlugin createFilterPlugin() {
        return new StringFilterPlugin(configView.getFilterText());
    }

    @Override
    public LogAnalyzerFinderPlugin createFinderPlugin() {
        return new StringFinderPlugin(configView.getFilterText());
    }
}
