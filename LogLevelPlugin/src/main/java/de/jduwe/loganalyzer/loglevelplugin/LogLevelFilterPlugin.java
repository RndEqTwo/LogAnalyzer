package de.jduwe.loganalyzer.loglevelplugin;

import de.jduwe.loganalyzer.ILogAnalyzerFilterPlugin;
import de.jduwe.loganalyzer.ILogAnalyzerPluginFactory;
import javafx.scene.layout.Region;

import java.util.List;

public class LogLevelFilterPlugin implements ILogAnalyzerFilterPlugin {

    List<String> filterTexts;

    public LogLevelFilterPlugin(List<String> filterTexts) {
        this.filterTexts = filterTexts;
    }

    @Override
    public String getDisplayName() {
        return "Log Level Filter";
    }

    @Override
    public ILogAnalyzerPluginFactory getFactoryInstance() {
        return null;
    }

    @Override
    public Region getFilledView() {
        return null;
    }

    @Override
    public boolean filter(String line) {

        for(String filterText : filterTexts){
            if (line.contains(filterText)){
                return true;
            }
        }
        return false;
    }
}
