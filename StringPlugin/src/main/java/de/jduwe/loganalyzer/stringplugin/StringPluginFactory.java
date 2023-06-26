package de.jduwe.loganalyzer.stringplugin;

import de.jduwe.loganalyzer.IEventManager;
import de.jduwe.loganalyzer.ILogAnalyzerFilterPlugin;
import de.jduwe.loganalyzer.ILogAnalyzerFinderPlugin;
import de.jduwe.loganalyzer.ILogAnalyzerPluginFactory;
import javafx.scene.layout.Region;
import org.pf4j.Extension;

@Extension
public class StringPluginFactory implements ILogAnalyzerPluginFactory {

    private ConfigView configView;
    private IEventManager eventManager;

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
    public void setEventManager(IEventManager eventManager) {
        this.eventManager = eventManager;
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
    public ILogAnalyzerFilterPlugin createFilterPlugin() {
        return new StringFilterPlugin(eventManager, configView.getFilterText());
    }

    @Override
    public ILogAnalyzerFinderPlugin createFinderPlugin() {
        return new StringFinderPlugin(eventManager, configView.getFilterText());
    }
}
