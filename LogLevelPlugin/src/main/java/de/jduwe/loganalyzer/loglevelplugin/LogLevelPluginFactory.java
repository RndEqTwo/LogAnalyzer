package de.jduwe.loganalyzer.loglevelplugin;

import de.jduwe.loganalyzer.IEventManager;
import de.jduwe.loganalyzer.ILogAnalyzerFilterPlugin;
import de.jduwe.loganalyzer.ILogAnalyzerFinderPlugin;
import de.jduwe.loganalyzer.ILogAnalyzerPluginFactory;
import javafx.scene.layout.Region;
import org.pf4j.Extension;

@Extension
public class LogLevelPluginFactory implements ILogAnalyzerPluginFactory {

    private ConfigView lastUsedView;
    private IEventManager eventManager;

    public LogLevelPluginFactory() {
        lastUsedView = new ConfigView();
    }

    @Override
    public String getName() {
        return "Log Level Plugin";
    }

    @Override
    public String getVersion() {
        return "0.0.1";
    }

    @Override
    public String getDescription() {
        return "Sucht oder Filtert nach bestimmten Log Levels";
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
        return false;
    }

    @Override
    public Region createView() {
        lastUsedView = new ConfigView();
        return lastUsedView;
    }

    @Override
    public ILogAnalyzerFilterPlugin createFilterPlugin() {
        return new LogLevelFilterPlugin(lastUsedView.getFilterTexts());
    }

    @Override
    public ILogAnalyzerFinderPlugin createFinderPlugin() {
        return null;
    }
}
