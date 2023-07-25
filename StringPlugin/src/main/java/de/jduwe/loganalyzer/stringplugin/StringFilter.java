package de.jduwe.loganalyzer.stringplugin;

import de.jduwe.loganalyzer.IEventManager;
import de.jduwe.loganalyzer.ILogAnalyzerFilter;
import de.jduwe.loganalyzer.ILogAnalyzerPlugin;
import javafx.scene.layout.Region;
import org.pf4j.Extension;


public class StringFilter implements ILogAnalyzerFilter {

    private String filterText;
    private IEventManager eventManager;

    public StringFilter(IEventManager eventManager, String filterText) {
        this.eventManager = eventManager;
        this.filterText = filterText;
    }

    @Override
    public String getDisplayName() {
        return "\"" + filterText + "\"";
    }


    @Override
    public boolean filter(String line) {
        return line.contains(filterText);
    }
}
