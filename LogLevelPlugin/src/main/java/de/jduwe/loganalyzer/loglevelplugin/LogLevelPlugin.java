package de.jduwe.loganalyzer.loglevelplugin;

import de.jduwe.loganalyzer.IEventManager;
import de.jduwe.loganalyzer.ILogAnalyzerFilter;
import de.jduwe.loganalyzer.ILogAnalyzerFinder;
import de.jduwe.loganalyzer.ILogAnalyzerPlugin;
import javafx.scene.layout.Region;
import org.pf4j.Extension;

import java.util.Properties;

@Extension
public class LogLevelPlugin implements ILogAnalyzerPlugin {

    private ConfigView lastUsedView;
    private IEventManager eventManager;

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
    public void setProperties(Properties properties) {

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
    public Region createSettingsView() {
        lastUsedView = new ConfigView();
        return lastUsedView;
    }

    @Override
    public ILogAnalyzerFilter createFilter() {
        return new LogLevelFilter(lastUsedView.getFilterTexts());
    }

    @Override
    public ILogAnalyzerFinder createFinder() {
        return null;
    }
}
