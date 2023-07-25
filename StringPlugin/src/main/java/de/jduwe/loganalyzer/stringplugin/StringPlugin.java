package de.jduwe.loganalyzer.stringplugin;

import de.jduwe.loganalyzer.IEventManager;
import de.jduwe.loganalyzer.ILogAnalyzerFilter;
import de.jduwe.loganalyzer.ILogAnalyzerFinder;
import de.jduwe.loganalyzer.ILogAnalyzerPlugin;
import javafx.scene.layout.Region;
import org.pf4j.Extension;

import java.util.Properties;

@Extension
public class StringPlugin implements ILogAnalyzerPlugin {

    private ConfigView configView;
    private IEventManager eventManager;
    private Properties properties;

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
    public void setProperties(Properties properties) {
        this.properties = properties;
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
    public Region createSettingsView() {
        configView = new ConfigView();
        return configView;
    }

    @Override
    public ILogAnalyzerFilter createFilter() {
        return new StringFilter(eventManager, configView.getFilterText());
    }

    @Override
    public ILogAnalyzerFinder createFinder() {
        return new StringFinder(eventManager, configView.getFilterText());
    }
}
