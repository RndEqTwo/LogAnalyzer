package de.jduwe.loganalyzer.jsonplugin;

import de.jduwe.loganalyzer.IEventManager;
import de.jduwe.loganalyzer.ILogAnalyzerFilter;
import de.jduwe.loganalyzer.ILogAnalyzerFinder;
import de.jduwe.loganalyzer.ILogAnalyzerPlugin;
import javafx.scene.layout.Region;
import org.pf4j.Extension;

import java.util.Properties;

@Extension
public class JsonPlugin implements ILogAnalyzerPlugin {
    private ConfigView lastUsedView;
    private IEventManager eventManager;
    private Properties properties;

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
        return null;
    }

    @Override
    public ILogAnalyzerFilter createFilter() {
        return new JsonFilter(eventManager, properties);
    }

    @Override
    public ILogAnalyzerFinder createFinder() {
        return new JsonFinder(eventManager, properties);
    }
}
