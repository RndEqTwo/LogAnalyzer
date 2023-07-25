package de.jduwe.loganalyzer.jsonplugin;

import de.jduwe.loganalyzer.IEventManager;
import de.jduwe.loganalyzer.ILogAnalyzerFilter;
import de.jduwe.loganalyzer.ILogAnalyzerPlugin;
import javafx.scene.layout.Region;

import java.util.Properties;

public class JsonFilter implements ILogAnalyzerFilter {

    private IEventManager eventManager;
    private Properties properties;

    public JsonFilter(IEventManager eventManager, Properties properties) {
        this.eventManager = eventManager;
        this.properties = properties;
    }

    @Override
    public String getDisplayName() {
        return "Json Filter";
    }


    @Override
    public boolean filter(String line) {
        JsonAnalyzer analyzer = new JsonAnalyzer(properties);
        return analyzer.parse(line) != null;
    }
}
